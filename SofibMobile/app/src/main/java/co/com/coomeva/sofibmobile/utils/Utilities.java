
package co.com.coomeva.sofibmobile.utils;

import android.net.Uri;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


/**
 * @author Zathura Code Generator http://code.google.com/p/zathura/
 *
 */
@SuppressWarnings("deprecation")
public class Utilities {

	public static final String decimalFormat = "#.##";
	public static DecimalFormat formatoMoneda = new DecimalFormat("#,###.00");

	public static boolean isNumeric(String word) {
		boolean ret = false;
		Pattern pat = Pattern.compile("[^0-9',.\\s]");
		Matcher mat = pat.matcher(word);
		if (!mat.find()) {
			ret = true;
		}
		return ret;
	}

	/**
	 * 
	 * @param word
	 * @return Expresion regular "(\\d){1,10}\\.(\\d){1,10}" (\\d)digito
	 *         {1,10}de 1 a 10 caracteres \\. punto
	 * 
	 */
	public static boolean isDecimal(String word) {
		boolean ret = false;
		Pattern pat = Pattern.compile("(\\d){1,8}\\.(\\d){0,2}");
		Matcher mat = pat.matcher(word);
		if (!mat.find()) {
			ret = true;
		}
		return ret;
		// DoubleValidator doubleValidator = new DoubleValidator();
		// return doubleValidator.isValid(word);
	}


    public static String formatearNumero(Object numero){

        if(numero!=null) {
            return formatoMoneda.format(numero);

        }else{
            return "0";
        }
    }

    public static String formatearNumeroAPorcentaje(Object numero){
        if(numero!=null) {
            Double numeroEntero = (Double)numero * 100;
            DecimalFormat df = new DecimalFormat("#.##");
            return df.format(numeroEntero)+"%";
        }else{
            return "0%";
        }
    }

    public static String formatearNumeroAMoneda(Object numero){

        if(numero!=null) {
            return "$" + formatoMoneda.format(numero);

        }else{
            return "$0";
        }
    }

    public static String formatearNumeroAMoneda(Long numero){

        if(numero!=null) {

            if(numero >=0) {
                return "$" + formatoMoneda.format(numero);
            }else{
                numero = numero * -1;
                return "($" + formatoMoneda.format(numero)+")";
            }

        }else{
            return "$0";
        }
    }

    public static String formatearNumeroDoubleAMoneda(Double numero){

        if(numero!=null) {

            if(numero < 0){
                numero = numero * -1;

                return "($" + formatoMoneda.format(numero)+")";
            }else{
                return "$" + formatoMoneda.format(numero);
            }


        }else{
            return "$0";
        }
    }

    public static boolean esNumerico(String cadena){
        try {
            Long.parseLong(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

    public static boolean esNumericoDouble(String cadena){
        try {
            Double.parseDouble(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

	public static boolean checkNumberAndCheckWithPrecisionAndScale(
			String fieldValue, Integer precision, Integer scale) {
		boolean ret = false;
		if (fieldValue != null && precision != null && scale != null) {
			if (fieldValue.contains("E") && scale != 0) {
				String dfString = "# # . # # # # # # # # # # # # # # # #";
				dfString = dfString.replace(" ", "");
				DecimalFormat df = new DecimalFormat(dfString);
				fieldValue = df.format(new Double(fieldValue));
				if (fieldValue.length() > 0 && !fieldValue.contains(".")) {
					fieldValue = fieldValue + ".0";
				}
			}
			fieldValue = fieldValue.replace(".", "%");
			String[] spitedFieldValue = fieldValue.split("%");
			if (spitedFieldValue.length == 2 && precision != 0) {
				String precisionTmp = spitedFieldValue[0];
				String scaleTmp = spitedFieldValue[1];
				if (!isNumeric(precisionTmp)) {
					return false;
				}
				if (!isNumeric(scaleTmp)) {
					return false;
				}
				if ((precisionTmp.length() <= precision)
						&& (scaleTmp.length() <= scale)) {
					ret = true;
				}
			} else {
				if (spitedFieldValue.length == 1 && precision != 0
						&& scale == 0) {
					String precisionTmp = spitedFieldValue[0];
					if (!isNumeric(precisionTmp)) {
						return false;
					}
					if ((precisionTmp.length() <= precision)) {
						ret = true;
					}
				} else {
					return false;
				}
			}
		}
		return ret;
	}

	public static boolean checkWordAndCheckWithlength(String word,
			Integer length) {
		boolean ret = false;
		if (word.length() <= length) {
			ret = true;
		}
		return ret;
	}

	public static boolean isOnlyLetters(String word) {
		boolean ret = false;
		Pattern pat = Pattern.compile("[^A-Za-z0-9',.\\s]");
		Matcher mat = pat.matcher(word);
		if (!mat.find()) {
			ret = true;
		}
		return ret;
	}

	public static String formatDateWithoutTimeInAStringForBetweenWhere(
			Date fecha) {
		int year = fecha.getYear() + 1900;
		int month = fecha.getMonth() + 1;
		int day = fecha.getDate();
//		String date = "" + year + "-" + month + "-" + day;
		String date = "" + day + "/" + month + "/" + year;
		return date;
	}

	public static boolean validationsList(List list) {
		if (list != null) {
			if (!list.isEmpty() && list.size() > 0) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}


	/**
	 * 
	 * @param object
	 * @param object2
	 * @param privateFields
	 * @return
	 * @throws Exception
	 */
	public static boolean matchClasses(Object object, Object object2,
									   boolean privateFields) throws Exception {

		boolean couldPerformTask = false;
		Object paramsObj[] = {};

		Class tmpClass = object.getClass();
		Class tmpClass2 = object2.getClass();

		Field field[] = tmpClass.getDeclaredFields();
		Field field2[] = tmpClass2.getDeclaredFields();

		Method method[] = tmpClass.getMethods();
		Method method2[] = tmpClass2.getMethods();

		String tmpName = new String();
		String tmpName2 = new String();

		Field tmpField;
		Field tmpField2;

		Method tmpMethod;
		Method tmpMethod2;

		Object tmpInfo = new Object();
		Object tmpInfo2 = new Object();

		Class[] paramTypes = null;
		Class[] paramTypes1 = null;

		if (privateFields) {

			try {
				if (method != null && method.length > 0) {

					for (int i = 0; i < method.length; i++) {
						tmpMethod = method[i];
						tmpMethod2 = method2[i];

						if (tmpMethod != null && tmpMethod2 != null) {
							paramTypes = tmpMethod.getParameterTypes();
							tmpName = tmpMethod.getName().substring(0, 3);

							paramTypes1 = tmpMethod2.getParameterTypes();
							tmpName2 = tmpMethod2.getName().substring(0, 3);

							if (tmpName.equals("get") && tmpName2.equals("get")) {

								tmpInfo = tmpMethod.invoke(object, paramsObj);
								tmpInfo2 = tmpMethod2
										.invoke(object2, paramsObj);

								if (tmpInfo != null && tmpInfo2 != null) {
									try {
										if (tmpInfo.equals(tmpInfo2)) {
											couldPerformTask = true;
										} else {
											return false;
										}
									} catch (Exception e) {

										if (tmpInfo == tmpInfo2) {
											couldPerformTask = true;
										} else {
											return false;
										}
									}
								}
							}
						}
					}

				} else {
					throw new Exception(
							"One of the the Classes has no \"get\" methods please check");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			try {
				for (int j = 0; j < field.length; j++) {
					tmpField = field[j];
					tmpField2 = field2[j];

					if (tmpField != null && tmpField2 != null) {

						tmpInfo = tmpField.get(object);
						tmpInfo2 = tmpField2.get(object2);

						if (tmpInfo != null && tmpInfo2 != null) {
							try {
								if (tmpInfo.equals(tmpInfo2)) {
									couldPerformTask = true;
								} else {
									return false;
								}
							} catch (Exception e) {

								if (tmpInfo == tmpInfo2) {
									couldPerformTask = true;
								} else {
									return false;
								}
							}
						}
					} else {
						throw new Exception(
								"One of the the Classes has no fields methods please check");
					}
				}
			} catch (IllegalAccessException ea) {
				throw new Exception(
						"One of the objects you are trying to compare has its fields private please use the method way");
			} catch (Exception e) {
				throw e;
			}
		}
		return couldPerformTask;
	}

	public String constructQuery(Object[] variables, Object[] variablesBetween,
								 Object[] variablesBetweenDates) throws Exception {
		String where = new String();
		String tempWhere = new String();

		if (variables != null) {
			for (int i = 0; i < variables.length; i++) {
				if ((variables[i] != null) && (variables[i + 1] != null)
						&& (variables[i + 2] != null)
						&& (variables[i + 3] != null)) {
					String variable = (String) variables[i];
					Boolean booVariable = (Boolean) variables[i + 1];
					Object value = variables[i + 2];
					String comparator = (String) variables[i + 3];

					if (booVariable.booleanValue()) {
						tempWhere = (tempWhere.length() == 0) ? ("(model."
								+ variable + " " + comparator + " \'" + value + "\' )")
								: (tempWhere + " AND (model." + variable + " "
										+ comparator + " \'" + value + "\' )");
					} else {
						tempWhere = (tempWhere.length() == 0) ? ("(model."
								+ variable + " " + comparator + " " + value + " )")
								: (tempWhere + " AND (model." + variable + " "
										+ comparator + " " + value + " )");
					}
				}

				i = i + 3;
			}
		}

		if (variablesBetween != null) {
			for (int j = 0; j < variablesBetween.length; j++) {
				if ((variablesBetween[j] != null)
						&& (variablesBetween[j + 1] != null)
						&& (variablesBetween[j + 2] != null)
						&& (variablesBetween[j + 3] != null)
						&& (variablesBetween[j + 4] != null)) {
					String variable = (String) variablesBetween[j];
					Object value = variablesBetween[j + 1];
					Object value2 = variablesBetween[j + 2];
					String comparator1 = (String) variablesBetween[j + 3];
					String comparator2 = (String) variablesBetween[j + 4];
					tempWhere = (tempWhere.length() == 0) ? ("(" + value + " "
							+ comparator1 + " " + variable + " and " + variable
							+ " " + comparator2 + " " + value2 + " )")
							: (tempWhere + " AND (" + value + " " + comparator1
									+ " " + variable + " and " + variable + " "
									+ comparator2 + " " + value2 + " )");
				}

				j = j + 4;
			}
		}

		if (variablesBetweenDates != null) {
			for (int k = 0; k < variablesBetweenDates.length; k++) {
				if ((variablesBetweenDates[k] != null)
						&& (variablesBetweenDates[k + 1] != null)
						&& (variablesBetweenDates[k + 2] != null)) {
					String variable = (String) variablesBetweenDates[k];
					Object object1 = variablesBetweenDates[k + 1];
					Object object2 = variablesBetweenDates[k + 2];
					String value = null;
					String value2 = null;

					try {
						Date date1 = (Date) object1;
						Date date2 = (Date) object2;
						value = Utilities
								.formatDateWithoutTimeInAStringForBetweenWhere(date1);
						value2 = Utilities
								.formatDateWithoutTimeInAStringForBetweenWhere(date2);
					} catch (Exception e) {
						throw e;
					}

					tempWhere = (tempWhere.length() == 0) ? ("(model."
							+ variable + " between \'" + value + "\' and \'"
							+ value2 + "\')") : (tempWhere + " AND (model."
							+ variable + " between \'" + value + "\' and \'"
							+ value2 + "\')");
				}

				k = k + 2;
			}
		}

		if (tempWhere.length() == 0) {
			where = "";
		} else {
			where = "where (" + tempWhere + ")";
		}

		return where;
	}
	
	public static Double truncateDouble(Double value) throws Exception {
		DecimalFormat df = new DecimalFormat(decimalFormat);
		
		return Double.valueOf(df.format(value.doubleValue()));
	}
	
	public static Double truncateDouble(Double value, String decimalFormat) throws Exception {
		DecimalFormat df = new DecimalFormat(decimalFormat);
		
		return Double.valueOf(df.format(value.doubleValue()));
	}

	public static byte[] compress(String str) throws Exception {
		if (str == null || str.length() == 0) {
			return null;
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(out);
		gzip.write(str.getBytes());
		gzip.close();
		return out.toByteArray();
	}

	public static String decompress(byte[] bytes) throws Exception {
		if (bytes == null || bytes.length == 0) {
			return null;
		}

		GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(bytes));
		BufferedReader bf = new BufferedReader(new InputStreamReader(gis, "UTF-8"));
		String outStr = "";
		String line;
		while ((line=bf.readLine())!=null) {
			outStr += line;
		}

		return outStr;
	}

    public static void decompress(InputStream from, OutputStream to) throws Exception {

        GZIPInputStream gis = new GZIPInputStream(from);
        BufferedReader bf = new BufferedReader(new InputStreamReader(gis, "UTF-8"));
        byte[] buffer = new byte[1024];

        int len;
        while ((len = gis.read(buffer)) > 0) {
            to.write(buffer, 0, len);
        }
    }


	public static String serviceIntent(File url) {

		if (url.toString().contains(".doc") || url.toString().contains(".docx")) {
			// Word document
			return "application/msword";
		} else if (url.toString().contains(".pdf")) {
			// PDF file
			return "application/pdf";
		} else if (url.toString().contains(".ppt") || url.toString().contains(".pptx")) {
			// Powerpoint file
			return "application/vnd.ms-powerpoint";
		} else if (url.toString().contains(".xls") || url.toString().contains(".xlsx")) {
			// Excel file
			return "application/vnd.ms-excel";
		} else if (url.toString().contains(".zip") || url.toString().contains(".rar")) {
			// WAV audio file
			return "application/x-wav";
		} else if (url.toString().contains(".rtf")) {
			// RTF file
			return "application/rtf";
		} else if (url.toString().contains(".wav") || url.toString().contains(".mp3")) {
			// WAV audio file
			return "audio/x-wav";
		} else if (url.toString().contains(".gif")) {
			// GIF file
			return "image/gif";
		} else if (url.toString().contains(".jpg") || url.toString().contains(".jpeg") || url.toString().contains(".png")) {
			// JPG file
			return "image/jpeg";
		} else if (url.toString().contains(".txt")) {
			// Text file
			return "text/plain";
		} else if (url.toString().contains(".3gp") || url.toString().contains(".mpg") || url.toString().contains(".mpeg") || url.toString().contains(".mpe") || url.toString().contains(".mp4") || url.toString().contains(".avi")) {
			// Video files
			return "video/*";
		} else {
			return "*/*";
		}

	}

	public static String formatearNumeroTexto(String numeroTexto){

		Double numero = 0d;
		if(numeroTexto != null && !numeroTexto.trim().equals("") && isNumeric(numeroTexto)){
			numero = Double.parseDouble(numeroTexto);
		}else{
			numero = 0d;
		}

		return formatearNumeroDoubleAMoneda(numero);
	}

}