package fr.cg95.cvq.service.request.school.impl;

import fr.cg95.cvq.business.request.Request;
import fr.cg95.cvq.business.request.school.GlobalSchoolRegistrationRequest;
import fr.cg95.cvq.service.request.condition.EqualityChecker;
import fr.cg95.cvq.service.request.impl.RequestService;

public final class GlobalSchoolRegistrationRequestService extends RequestService {

    @Override
    public void init() {
        GlobalSchoolRegistrationRequest.conditions.put("estDerogation", new EqualityChecker("true"));
        GlobalSchoolRegistrationRequest.conditions.put("estRestauration", new EqualityChecker("true"));
        GlobalSchoolRegistrationRequest.conditions.put("motifsDerogation", new EqualityChecker("Autre"));
    }

    @Override
    public boolean accept(final Request request) {
        return request instanceof GlobalSchoolRegistrationRequest;
    }

    @Override
    public Request getSkeletonRequest() {
        return new GlobalSchoolRegistrationRequest();
    }

    public Map<String, Map<String, String>> getSchools(Long childId) throws CvqObjectNotFoundException {
        String method = "ListeEcoles";
        Map<String, Map<String,String>> schools = new HashMap<String, Map<String,String>>();

        // get child info
        Individual child = individualService.getById(childId);
        String chId = externalHomeFolderService.getIndividualMapping(externalServiceLabel, child).getExternalCapDematId();
        logger.debug("Get externalCapDematId for " + child.getFullName() + " - " + chId);
        String streetNumber = child.getAddress().getStreetNumber();
        String rivoliCode = child.getAddress().getStreetRivoliCode();
        String postalCode = child.getAddress().getPostalCode();

        Vector<Parameter> parameters = new Vector<Parameter>();
        parameters.addElement(new Parameter("idenfantexterne", String.class, chId, null));
        parameters.addElement(new Parameter("nrue", String.class, streetNumber, null));
        parameters.addElement(new Parameter("rivoli", String.class, rivoliCode, null));
        parameters.addElement(new Parameter("cp", String.class, postalCode, null));
        parameters.addElement(new Parameter("codeappli", String.class, "Capdemat", null));
        try {
            Call call = new Call();
            String encodingStyleURI = org.apache.soap.Constants.NS_URI_SOAP_ENC;
            call.setEncodingStyleURI(encodingStyleURI);
            call.setTargetObjectURI ("urn:WSPocketTechno2" );
            call.setMethodName(method);
            call.setParams(parameters);
            Response soap_response = call.invoke(new java.net.URL(urlws), "" );

            if (soap_response.generatedFault()) {
                Fault fault = soap_response.getFault ();
                logger.error("Error : " + fault.getFaultString());
                return schools;
            } else {
                Parameter soap_result = soap_response.getReturnValue();
                // add a header to xml return 'xmlns="http://www.capwebct.fr/capdemat"'
                String xmlresult = soap_result.getValue().toString();
                int index = xmlresult.indexOf("<ListeEcole") + "<ListeEcole".length();
                xmlresult = xmlresult.substring(0, index) + " xmlns=\"http://www.capwebct.fr/capdemat\"" + xmlresult.substring(index);
                logger.debug("Get soap response for child " + chId + " and rivoli code " + rivoliCode);
                // start treatment
                logger.debug("Parse : " + xmlresult);
                ListeEcoleDocument document = ListeEcoleDocument.Factory.parse(xmlresult);
                Map<String, String> schoolSectors = new HashMap<String, String>();
                Map<String, String> schoolDerogs = new HashMap<String, String>();
                if (document.getListeEcole().getListeEcoleSecteur() != null)
                    for (EcoleSecteurType est : document.getListeEcole().getListeEcoleSecteur().getEcoleSecteurArray()) {
                        schoolSectors.put(est.getIdEcoleSecteur(), est.getNomEcoleSecteur());
                    }
                if (document.getListeEcole().getListeEcoleDerog() != null)
                    for (EcoleDerogType edt : document.getListeEcole().getListeEcoleDerog().getEcoleDerogArray()) {
                        schoolDerogs.put(edt.getIdEcoleDerog(), edt.getNomEcoleDerog());
                    }
                schools.put("schoolSectors", schoolSectors);
                schools.put("schoolDerogs", schoolDerogs);
                return schools;
            }
        } catch (XmlException xe) {
            logger.error("XmlException : " + xe.getMessage() + " : ");
            xe.printStackTrace();
        }catch (Exception e) {
            logger.error("Exception : " + e.getMessage());
            e.printStackTrace();
        }
        return schools;
    }
}
