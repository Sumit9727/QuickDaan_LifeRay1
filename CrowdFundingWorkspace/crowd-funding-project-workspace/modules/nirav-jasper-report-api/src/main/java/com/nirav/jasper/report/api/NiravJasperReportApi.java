package com.nirav.jasper.report.api;

import com.nirav.jasper.report.api.bean.ParameterDetail;

import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceResponse;
import com.liferay.portal.reports.engine.console.model.*;

/**
 * @author Prakat-D-016
 */
public interface NiravJasperReportApi {
	public Map<String, List<ParameterDetail>> getDefinitionParameters(RenderRequest renderRequest, long definitionId);
	public void getDefinitionByRole(ResourceResponse resourceResponse, long roleId);
	public Entry generateReport(PortletRequest portletRequest, String format, long definitionId,
			String reportName, boolean isPreview);public void previewReport(PortletRequest portletRequest, String reportName, Entry entry, String format);
}