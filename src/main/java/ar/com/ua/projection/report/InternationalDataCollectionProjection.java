package ar.com.ua.projection.report;

import java.time.ZonedDateTime;

public interface InternationalDataCollectionProjection {

	String getGlobalId();

	String getPositionTitle();

	String getManagerToReport();

	String getCargoManagerToReport();

	String getTitle();

	String getSurname();

	String getFirstName();

	String getMiddleName();

	String getOtherName();

	String getPreferedName();

	String getDateOfBirth();

	String getGender();

	String getCountry();

	String getMailLaboral();

	String getStartDate();

	String getHorasDeTrabajo();

	String getFte();

	String getRateFrecuency();

	String getSalaryBasePayRate();

	String getReasonForSalaryChange();

	String getEmploymentType();

	String getPersonnelType();

	String getDepartment();

	ZonedDateTime getTermDate();

	String getTermReason();

	String getAntiguedad();

	String getAge();

	String getGeneration();

	String getDivission();

	String getDireccion();

	String getGerencia();

	String getSubgerencia();

	String getJefatura();

	String getOficina();

	String getActive();

	String getCategory();

}
