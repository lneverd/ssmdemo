package com.xiaow.ssmdemo.controller;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.cglib.beans.BeanMap;

import javax.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class EXCElController extends BaseController {
	public static int EXCEL_MAX = 65536;
	public static String _2003 = "xls";
	public static String _2007 = "xlsx";
	public String defFmt = "yyyy/MM/dd HH:mm:ss";

	@SuppressWarnings("rawtypes")
	protected void downExportExcel(String tplUrl, List list, String excelName, HttpServletResponse resp) {
		downloadExcel(exportExcel(tplUrl, list), excelName, resp);
	}

	protected void downloadExcel(Workbook wb, String excelName, HttpServletResponse resp) {
		try {
			excelName = new String(excelName.getBytes("UTF-8"), "iso-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		resp.setContentType("application/octet-stream");
		resp.setHeader("Content-Type", "application/vnd.ms-excel");
		resp.addHeader("Content-Disposition", "attachment;fileName=" + excelName);
		resp.setCharacterEncoding("UTF-8");
		OutputStream os = null;
		try {
			os = resp.getOutputStream();
			wb.write(os);
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static <T> Map<String, Object> obj2Map(T bean) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (bean != null) {
			BeanMap beanMap = BeanMap.create(bean);
			for (Object key : beanMap.keySet()) {
				map.put(key + "", beanMap.get(key));
			}
		}
		return map;
	}

	public static Workbook getTplWorkbook(String tplUrl) {
		InputStream is = EXCElController.class.getClassLoader().getResourceAsStream(tplUrl);
		Workbook wb = null;
		try {
			if (is == null) {
				is = new FileInputStream(tplUrl);
			}
			wb = new HSSFWorkbook(is);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return wb;
	}

	private int getClnRow(Sheet sheet) {
		int clnRow = 0;
		for (int i = 0; i < 10; i++) {
			Row row = sheet.getRow(i);
			if (row == null) {
				continue;
			}
			Cell clnCell = row.getCell(0);
			if (clnCell != null) {
				String cv = clnCell.getStringCellValue();
				if (cv != null && cv.contains("['")) {
					clnRow = i;
					break;
				}
			}
		}
		return clnRow;
	}

	private List<String> getTplClnList(Sheet sheet, int clnRow) {
		Row row1 = sheet.getRow(clnRow);
		if (row1 == null) {
			return null;
		}
		List<String> r1cells = new ArrayList<String>();
		for (Cell cell : row1) {
			String cv = cell.getStringCellValue();
			if (cv == null) {
				cv = "";
			} else {
				if (cv.contains("{'")) {
					int idx = cv.indexOf("{'");
					String temp = cv;
					cv = temp.substring(0, idx);
					defFmt = temp.substring(idx + 2, temp.length() - 2);
				}
				cv = cv.substring(2, cv.length() - 2);
			}
			r1cells.add(cv);
		}
		return r1cells;
	}

	@SuppressWarnings("rawtypes")
	public Workbook exportExcel(String tplUrl, List list) {
		Workbook wb = null;
		try {
			wb = getTplWorkbook(tplUrl);
			HSSFSheet sheet = (HSSFSheet) wb.getSheetAt(0);
			int clnRow = getClnRow(sheet);
			List<String> r1cells = getTplClnList(sheet, clnRow);
			sheet.removeRow(sheet.getRow(clnRow));
			int len = Math.min(EXCEL_MAX, list.size());
			for (int idx = 0; idx < len; idx++) {
				Map<String, Object> map = obj2Map(list.get(idx));
				HSSFRow row = sheet.createRow(idx + clnRow);
				for (String key : map.keySet()) {
					if (r1cells.contains(key)) {
						HSSFCell cell = row.createCell(r1cells.indexOf(key));
						Object value = map.get(key);
						if (value == null) {
							cell.setCellValue("");
						} else if (value instanceof Date) {
							CellStyle style = wb.createCellStyle();
							style.setDataFormat(wb.getCreationHelper().createDataFormat().getFormat(defFmt));
							cell.setCellValue(new Date());
							cell.setCellStyle(style);
						} else if (value instanceof Integer) {
							cell.setCellValue((Integer) value);
						} else if (value instanceof Float) {
							cell.setCellValue((Float) value);
						} else if (value instanceof Double) {
							cell.setCellValue((Double) value);
						} else if (value instanceof BigDecimal) {
							cell.setCellValue(((BigDecimal) value).doubleValue());
						} else {
							String val = value.toString();
							if (Boolean.TRUE.toString().equals(val.toLowerCase())) {
								cell.setCellValue("是");
							} else if (Boolean.FALSE.toString().equals(val.toLowerCase())) {
								cell.setCellValue("否");
							} else {
								cell.setCellValue(val);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			wb = null;
		}
		return wb;
	}

}
