<div class="txt-right">
  <a href="javascript:void(0);" onclick="YAHOO.capdematBo.request.search.switchSearchForm('simple');">
    <g:message code="action.goToSimpleSearch" />
  </a> | 
  <g:message code="action.goToAdvancedSearch" />
</div>

<div id="search-form">
  <h1><g:message code="request.header.advancedSearch" /></h1>
  <form method="POST" id="requestForm" class="advanced-search" action="<g:createLink action="search" />"> 
    <input type="hidden" id="totalRecords" name="totalRecords" value="${totalRecords}" />
    <input type="hidden" id="recordsReturned" name="recordsReturned" value="${recordsReturned}" />
    <input type="hidden" id="recordOffset" name="recordOffset" value="${recordOffset}" />
    <input type="hidden" id="sortBy" name="sortBy" value="${sortBy}" />
    <input type="hidden" id="filterBy" name="filterBy" value="${filterBy}" />
    <input type="hidden" id="mode" name="mode" value="advanced" />

    <div class="yui-g">
      <div class="yui-u first">
        <label for="requesterLastName"><g:message code="request.property.requesterLastName" /> :</label>
        <input type="text" name="requesterLastName" size="40" value="${params?.requesterLastName}" />
          
        <label for="id"><g:message code="request.property.requestId" /> :</label>
        <input type="text" name="id" size="40" value="${params?.id}" />
        
        <label for="homeFolderId"><g:message code="property.homeFolderId" /> :</label>
        <input type="text" name="homeFolderId" size="40" value="${params?.homeFolderId}" />
      </div>

      <div class="yui-u">
        <label for="creationDateFrom"><g:message code="property.creationDate" /> :</label>
        <input type="text" id="creationDateFrom" name="creationDateFrom" size="10" value="${params?.creationDateFrom}" />
        <a onclick="showCalendar('creationDateFromShow', 0);">
          <img id="creationDateFromShow" src="${createLinkTo(dir:'css/yui/calendar',file:'calendar.gif')}"/>
        </a>
        <div id="creationDateFromCalContainer" class="yui-cal"></div>
 
        <label for="creationDateTo"><g:message code="property.creationDate" /> :</label>
        <input type="text" id="creationDateTo" name="creationDateTo" size="10" value="${params?.creationDateTo}" />
        <a onclick="showCalendar('creationDateToShow', 1);">
          <img id="creationDateToShow" src="${createLinkTo(dir:'css/yui/calendar',file:'calendar.gif')}"/>
        </a>
        <div id="creationDateToCalContainer" class="yui-cal"></div>
      </div>

      <div style="clear:both;">&nbsp;</div>
      <input type="button" id="submitSearchRequest" name="submitSearchRequest"
        class="form-button" value="<g:message code="action.search" />"/>

    </div>
  </form>
</div>
