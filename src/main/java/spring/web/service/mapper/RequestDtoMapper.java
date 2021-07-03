package spring.web.service.mapper;

public interface RequestDtoMapper<D, T> {
    T mapToModel(D dto);
}
