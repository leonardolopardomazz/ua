package ar.com.ua.builder.report;

public interface IBuilderResponse<List, Dto> {

	public Dto listToDTo(List list);

}
