import java.io.File;

import fr.cg95.cvq.business.authority.LocalAuthorityResource
import fr.cg95.cvq.business.authority.LocalAuthorityResource.Type
import fr.cg95.cvq.service.authority.ILocalAuthorityRegistry

import org.apache.commons.lang.StringUtils;

/**
 * Used to access local authorities specific resources, eg images.
 */
class LocalAuthorityResourceController {
	
    ILocalAuthorityRegistry localAuthorityRegistry

    def localAuthorityResourceAdaptorService

    def defaultAction = "resource"

    def resource = {
        def localAuthorityResource = localAuthorityResourceAdaptorService.getLocalAuthorityResources()[params.id]
        File resource
        if (localAuthorityResource != null) {
            resource = localAuthorityRegistry.getLocalAuthorityResourceFile(
                params.id,
                params.version != null ? LocalAuthorityResource.Version.valueOf(params.version) : LocalAuthorityResource.Version.CURRENT)
            if (resource != null)
                renderResponse(resource, params.id, localAuthorityResource.type.contentType)
        } else {
            resource = localAuthorityRegistry.getLocalAuthorityResourceFile(
                Type.valueOf(params.type),
                params.filename,
                params.version != null ? LocalAuthorityResource.Version.valueOf(params.version) : LocalAuthorityResource.Version.CURRENT,
                true)
            if (resource != null && resource.exists())
                renderResponse(resource, params.filename, Type.valueOf(params.type).contentType)
        }

    }

    def rule = {
        File pdfFile =
            localAuthorityRegistry.getLocalAuthorityResourceFile(Type.PDF,
                CapdematUtils.requestTypeLabelAsDir(params.requestTypeLabel)
                + "/"  + params.filename, false)
        if (pdfFile.exists()) {
            renderResponse(pdfFile, params.filename, "application/pdf")
        }
    }

    def renderResponse(file, filename, contentType) {
        String extension = "." + StringUtils.substringAfter(contentType, "/")
        def filenameDetail = "attachment;filename=" + filename + extension
        byte[] data = file.readBytes()
        response.contentType = contentType
        response.addHeader("content-disposition", filenameDetail)
        response.contentLength = data.length
        response.outputStream << data
    }
}
