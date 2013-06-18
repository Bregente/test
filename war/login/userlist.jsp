<%
/* -------------------------------------------------------------------------------- 
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) RococoGlobal Technologies, Inc - All Rights Reserved 2013
 * -------------------------------------------------------------------------------- */
%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>システムユーザ管理画面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Struts-JQuery initialize and enable client validation -->
	<!--<sj:head jqueryui="true" jquerytheme="redmond" />-->
	<!--<script src="/struts/utils.js" type="text/javascript"></script>-->
	<!--<script src="/struts/xhtml/validation.js" type="text/javascript"></script>-->
	<script src="../js/jquery.ui.datepicker.js"></script>

	<!-- Custom libraries -->
	<link rel="stylesheet" href="../css/global.css">
	<link rel="stylesheet" href="../css/font-awesome.min.css">
	<link rel="stylesheet" href="../css/bootstrap.css">
	<style type="text/css">
	body { background-color:white; padding-top:60px; }
	</style>
	<script type="text/javascript" src="../js/cms-validation-util.js"></script>
	<script type="text/javascript" src="../js/sys-ad/sys-ad.js"></script>
	<style type="text/css">
	/* CUSTOM CSS */
      .field-label {
        padding-top:5px;
        width:80px;
      }
      .field-text {
        width:150px;
      }
      .field-date {
        width:100px;
      }
      .outline-panel {
        border:1px #E2E2E2 solid;
        border-radius:4px;
        padding-top:10px;
        padding-left:10px;
      }
	</style>
	
  </head>

  <body>
  
    <form id="frmUserList" action="create" class="form-horizontal" method="POST">
	 
	 <fmt:setBundle basename="application_en"/>
<c:set var="userInfoSessionBean" value="${userInfoSessionBean}" />

    <!-- Floating top navigation bar -->
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#">顧客管理システム</a>
          <div class="nav-collapse collapse">
         
            <p class="navbar-text pull-right"  >ようこそ、
             ${userInfoSessionBean.email}
              <a href ="#">logout</a></p>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
	 
	 
    <div class="container-fluid">
      <div class="row-fluid">

        <!-- ***** [START][SIDEBAR NAVIGATION PANEL] ***** -->
        <div class="span3" style="min-width: 300px">
          <s:action namespace="" name="side-nav" executeResult="true"></s:action>
        </div><!--/span-->
        <!-- ***** [END  ][SIDEBAR NAVIGATION PANEL] ***** -->

        <!-- ***** [START][CONTENTS PANEL] ***** -->
        <div class="span9">

          <!-- ***** [START][BREADCRUMBS PANEL] ***** -->
          <div class="masterhead">
            <ul class="breadcrumb">
              <li class="active">
              	<c:choose>
                	<c:when test="UserInfoSessionBean.userType=='sysAd'">
                 		 <fmt:message key="sysAdForm.screen.title" />
               		</c:when>
                	<c:otherwise>
                  		<fmt:message key="sysAdForm.screen.member.title"/>
                	</c:otherwise>
                </c:choose>
              </li>
            </ul>
          </div>
          <!-- ***** [END  ][BREADCRUMBS PANEL] ***** -->

          <!-- ***** [START][SCREEN_NAME PANEL] ***** -->
          <div class="masterhead">
            <h4 class="muted">
            	<fmt:message key="sysAdForm.screen.title" /> 
              </h4>
          </div>
          <!-- ***** [END  ][SCREEN_NAME PANEL] ***** -->

          <!-- ***** [START][SYSTEM_MESSAGES PANEL] ***** -->
          <!-- <s:if test="hasActionErrors()">
            <div class="alert alert-error">
              <button type="button" class="close" data-dismiss="alert">&times;</button>
              <strong>Error!</strong>&nbsp;<s:actionerror/>
            </div>
          </s:if> struts 2 -->

          <!--<s:if test="hasActionMessages()">
            <div class="alert alert-info">
              <button type="button" class="close" data-dismiss="alert">&times;</button>
              &nbsp;<s:actionerror/>
            </div>
          </s:if> struts 2 -->
          <!-- ***** [END  ][SYSTEM_MESSAGES PANEL] ***** -->

          <div class="row-fluid">
            <div id="divSearchFields" class="span12 outline-panel">

              <!-- ***** [START][VALIDATION_ERRORS PANEL] -->
              <div id="divValidationErrors" class="alert" style="margin-right:10px;display:none;">
                <button type="button" class="close" id="divValidErrClose">&times;</button>
                <strong><s:property value="getText('error.message.title')" /></strong><br />
                <s:fielderror cssStyle="color:inherit;background-color:inherit;border:0;margin-bottom:0;" />
                <ul>
                  <li></li>
                </ul>
              </div>
              <!-- ***** [START][VALIDATION_ERRORS PANEL] -->

              <!-- ========================================================================================== -->
              <!-- ***** [START][SEARCH_CONDITIONS PANEL] ***** -->
              <!-- ========================================================================================== -->
              <div class="row-fluid">
                <div class="span3" style="height:30px;margin-bottom:5px;">
                  <div class="control-group" style="margin-bottom:0px;">
                    <label class="control-label" for="searchFieldUserId">
                      <fmt:message key="sysAdForm.screen.userId"/>
                    </label>
                    <div class="controls" style="width:500px">
                      <input id="searchFieldUserId" name="searchFieldUserId"
                        class="field-text" cssErrorStyle="border-color:red;"
                        type="text" placeholder="ユーザID"
                        style="margin-bottom:5px;" theme="simple"></input>
                    </div>
                  </div>
                </div>
              </div>

              <div class="row-fluid">
                <div class="span3" style="height:30px;margin-bottom:5px;">
                  <div class="control-group" style="margin-bottom:0px;">
                    <label class="control-label" for="searchFieldUserId">
                      <fmt:message key="sysAdForm.screen.accountName"/>
                    </label>
                    <div class="controls" style="width:500px">
                      <input id="searchFieldAccountName" name="searchFieldAccountName"
                        class="field-text" cssErrorStyle="border-color:red;"
                        type="text" placeholder="アカウント名ID"
                        style="margin-bottom:5px;" theme="simple"></input>
                    </div>
                  </div>
                </div>
              </div>

              <div class="row-fluid">
                <div class="span3" style="height:30px;margin-bottom:5px;">
                  <div class="control-group">
                    <label class="control-label" for="datRegisterDate">
                     <fmt:message key="sysAdForm.screen.registerDate"/>
                    </label>
                    <div class="controls" style="width:500px">
                      <div class="input-append" style="margin-bottom:5px;">
                        <input id="datRegisterDate" name="datRegisterDate"
                          class="field-date" cssErrorStyle="border-color:red;"
                          type="text" placeholder="開始日"
                          style="margin-bottom:5px;"></input>
                        <button id="btnShowRegisterDate" class="btn" type="button">
                          <img alt="日付" src="/img/calendar.png" height="18" width="18">
                        </button>
                      </div>
                      <span>～</span>
                      <div class="input-append" style="margin-bottom:5px;">
                        <input id="datRegisterDateTo" name="datRegisterDateTo"
                          class="field-date" cssErrorStyle="border-color:red;"
                          type="text" placeholder="終了日"
                          style="margin-bottom:5px;"></input>
                        <button id="btnShowRegisterDateTo" class="btn" type="button">
                          <img alt="日付" src="/img/calendar.png" height="18" width="18">
                        </button>
                      </div>
                    </div>
                  </div>
                </div>
              </div>

              <div class="row-fluid">
                <div class="span3" style="height:30px;margin-bottom:5px;">
                  <div class="control-group">
                    <label class="control-label" for="datUpdateDate">
                      <fmt:message key="sysAdForm.screen.updateDate"/>
                    </label>
                    <div class="controls" style="width:500px">
                     <div class="input-append" style="margin-bottom:5px;">
                       <input id="datUpdateDate" name="datUpdateDate"
                          class="field-date" cssErrorStyle="border-color:red;"
                          type="text" placeholder="開始日"
                          style="margin-bottom:5px;"></input>
                       <button id="btnShowUpdateDate" class="btn" type="button">
                         <img alt="日付" src="/img/calendar.png" height="18" width="18" />
                       </button>
                     </div>
                     <span>～</span>
                     <div class="input-append" style="margin-bottom:5px;">
                       <input id="datUpdateDateTo" name="datUpdateDateTo"
                          class="field-date" cssErrorStyle="border-color:red;"
                          type="text" placeholder="終了日"
                          style="margin-bottom:5px;"></input>
                       <button id="btnShowUpdateDateTo" class="btn" type="button">
                         <img alt="日付" src="/img/calendar.png" height="18" width="18" />
                       </button>
                     </div>
                    </div>
                  </div>
                </div>
              </div>

              <div class="row-fluid">
                <div class="span3" style="height:30px;margin-bottom:5px;">
                  <div class="control-group">
                    <label class="control-label" for="datLastLogDate">
                      <fmt:message key="sysAdForm.screen.lastlog"/>
                    </label>
                    <div class="controls" style="width:500px;">
                      <div class="input-append" style="margin-bottom:5px;">
                        <input id="datLastLogDate" name="datLastLogDate"
                          class="field-date" cssErrorStyle="border-color:red;"
                          type="text" placeholder="開始日"
                          style="margin-bottom:5px;"></input>
                        <button id="btnShowLastLogDate" class="btn" type="button">
                          <img alt="日付" src="/img/calendar.png" height="18" width="18" />
                        </button>
                      </div>
                      <span>～</span>
                      <div class="input-append" style="margin-bottom:5px;">
                        <input id="datLastLogDateTo" name="datLastLogDateTo"
                          class="field-date" cssErrorStyle="border-color:red;"
                          type="text" placeholder="終了日"
                          style="margin-bottom:5px;"></input>
                        <button id="btnShowLastLogDateTo" class="btn" type="button">
                          <img alt="日付" src="/img/calendar.png" height="18" width="18" />
                        </button>
                      </div>
                    </div>
                  </div>
                </div>
              </div>

              <div class="row-fluid">
                <div class="span12" style="height:30px;margin-bottom:5px;">
                  <checkbox id="chkValidity" name="chkValidity"
                    label=${"sysAdForm.screen.validity"}
                    labelposition="left"></checkbox>
                  </div>
              </div>

              <div class="row-fluid">
                <div class="span12">
                  <button id="btnSearch" type="button" class="btn btn-small btn-primary comm-btn">
                    <fmt:message key="sysAdForm.screen.search"/>
                    </button>
                  </div>
              </div>
              <!-- ========================================================================================== -->
              <!-- ***** [END  ][SEARCH_CONDITIONS PANEL] ***** -->
              <!-- ========================================================================================== -->
            </div>
          </div>

          <div class="row-fluid">
            <div id="gridOutput" class="span12 outline-panel" style="margin-top:5px;">
              <!-- ***** [START][RESULT_UPPER_CONTROLS PANEL] ***** -->
              <div class="row-fluid">
                <div class="span1">
                  <button id="btnShowAddAdmin" class="btn" type="button">
                  	<i class="icon-plus" style="height:40px; width:40px;"></i>
                  </button>
                </div>
                <div class="span1">
                  <button id="btnShowDetails" class="btn" type="button">
                  	<i class="icon-edit" style="height:40px; width:40px;"></i>
                  </button>
                </div>
                <div class="span1">
                  <button id="btnDelUser" class="btn" type="button">
                  	<i class="icon-minus" style="height:40px; width:40px;"></i>
                  </button>
                </div>
              </div>
              <!-- ***** [END  ][RESULT_UPPER_CONTROLS PANEL] ***** -->

              <!-- ***** [START][RESULTS_LIST PANEL] ***** -->
              <div class="row-fluid" style="margin-top:5px;">
                <div class="span12" style="padding-right:50px;">

<!-- ========================================================================================== -->
<!-- ***** [START][JQGRID CONTROL PANEL] ***** -->
<!-- ========================================================================================== -->
    <s:if test="hasFieldErrors()">
        <s:url var="remoteurl" action="jsontable-userlist" escapeAmp="false">
          <s:param name="validity"       value="%{chkValidity}"></s:param>
        </s:url>
    </s:if>
    <s:else>
	    <s:url var="remoteurl" action="jsontable-userlist" escapeAmp="false">
	      <s:param name="userId"         value="%{searchFieldUserId}"></s:param>
	      <s:param name="accountName"    value="%{searchFieldAccountName}"></s:param>
	      <s:param name="registerDate"   value="%{datRegisterDate}"></s:param>
	      <s:param name="registerDateTo" value="%{datRegisterDateTo}"></s:param>
	      <s:param name="updateDate"     value="%{datUpdateDate}"></s:param>
	      <s:param name="updateDateTo"   value="%{datUpdateDateTo}"></s:param>
	      <s:param name="lastLogDate"    value="%{datLastLogDate}"></s:param>
	      <s:param name="lastLogDateTo"  value="%{datLastLogDateTo}"></s:param>
	      <s:param name="validity"       value="%{chkValidity}"></s:param>
	    </s:url>
    </s:else>
    <sjg:grid
        id="gridtable" shrinkToFit="false" autowidth="true"
        dataType="json" href="%{remoteurl}"
        gridModel="userList"
        multiselect="true"
        rowList="10,15,20" rowNum="15" rownumbers="false" loadonce="false"
        pager="true" rownumbers="true"
        loadingText="%{getText('gen.grid.text.loading')}"
        onGridCompleteTopics="gridSuccessTopics">
        <% /*<sjg:gridColumn
          name="userId" index="userId"
          title=" "
          edittype="checkbox" formatter="checkbox" editable="true" formatoptions="{disabled:false}"
          width="20"
          sortable="false" align="center"
          onclick="onRowClick"/>*/ %>
        <sjg:gridColumn
          name="userId" index="userId"
          title="%{getText('userList.screen.grid.userid')}" width="120" sortable="true" />
        <sjg:gridColumn
          name="accountName" index="accountName"
          title="%{getText('userList.screen.grid.name')}" width="220" sortable="true" />
        <sjg:gridColumn
          name="registerDate" index="registerDate"
          title="%{getText('userList.screen.grid.registerdate')}" width="150"
          sortable="true" align="center" />
        <sjg:gridColumn
          name="updateDate" index="updateDate"
          title="%{getText('userList.screen.grid.updatedate')}" width="150"
          sortable="true" align="center" />
        <sjg:gridColumn
          name="lastLog" index="lastLog"
          title="%{getText('userList.screen.grid.lastlog')}" width="150"
          sortable="true" align="center" />
        <sjg:gridColumn
          name="status" index="status"
          title="%{getText('userList.screen.grid.validity')}" width="36"
          sortable="true" align="center" />
    </sjg:grid>
<!-- ========================================================================================== -->
<!-- ***** [END  ][JQGRID CONTROL PANEL] ***** -->
<!-- ========================================================================================== -->

                </div>
              </div>
              <!-- ***** [END  ][RESULTS_LIST PANEL] ***** -->

            </div>
          </div>

        </div>
        <!-- ***** [END  ][CONTENTS PANEL] ***** -->

      </div>
    </div>

      <s:hidden id="hdnUserId" name="userListForm.userId"></s:hidden>
   	
		<table border ="1">
			<tr>
				<td>USER ID</td>
				<td>EMAIL</td>
				<td>STATUS</td>
				<td>DATE REGISTERED</td>
				<td>LAST LOGGED IN</td>
			</tr>
				<c:forEach var="e" items="${userList}">			
			<tr>
				<td>${f:h(e.userId)} </td>
				<td>${f:h(e.email)}</td>
				<td>${f:h(e.status)}</td>
				<td>${f:h(e.registerDate)}</td>
				<td>${f:h(e.lastLog)}</td>
			</tr>
				</c:forEach>
			
		</table>
		<table>
			<tr>
				<td>email</td>
				<td>accountname</td>
				<td>password</td>
				<td>type</td>
			</tr>
			<tr>
				<td> 
					<input id="email" name="email"
                        class="field-text" cssErrorStyle="border-color:red;"
                        type="text" style="margin-bottom:5px;" theme="simple"/>
               </td>
               <td>
               		<input id="accountName" name="accountName"
                        class="field-text" cssErrorStyle="border-color:red;"
                        type="text" style="margin-bottom:5px;" theme="simple"/>
               </td>
               <td>
               		<input id="password" name="password"
                        class="field-text" cssErrorStyle="border-color:red;"
                        type="text" style="margin-bottom:5px;" theme="simple"/>
               </td>
               <td>
               		<input id="type" name="type"
                        class="field-text" cssErrorStyle="border-color:red;"
                        type="text" style="margin-bottom:5px;" theme="simple"/>
               </td>
               <td span="4" align="right">
					<input type="submit" name="insert" value="insert"/>
				</td>
			</tr>
		</table>
		
	 </form>	
  </body>
</html>