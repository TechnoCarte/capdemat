package fr.cg95.cvq.service.request.school;

import fr.cg95.cvq.business.request.school.*;
import fr.cg95.cvq.business.users.HomeFolder;
import fr.cg95.cvq.business.users.Adult;
import fr.cg95.cvq.testtool.TestUtils;

/**
 * Generated by Groovy only if not present, can be edited safely !
 */
public class GlobalSchoolRegistrationRequestFeeder {

    public static void feed(GlobalSchoolRegistrationRequest request) {
    }

	public static void setSubject(GlobalSchoolRegistrationRequest request,
	        String subjectPolicy, Adult requester, HomeFolder homeFolder) {
		
		TestUtils.feedRequestSubject(request, subjectPolicy, requester, homeFolder);
	}
}
