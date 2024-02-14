package ar.com.ua.builder.report;

public interface IBuilderResponse<ListProjection, ListDto> {

	public ListDto listToDto(ListProjection list);

}
