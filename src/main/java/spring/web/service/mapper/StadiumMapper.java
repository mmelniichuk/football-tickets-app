package spring.web.service.mapper;

import org.springframework.stereotype.Component;
import spring.web.dto.request.StadiumRequestDto;
import spring.web.dto.response.StadiumResponseDto;
import spring.web.model.Stadium;

@Component
public class StadiumMapper implements RequestDtoMapper<StadiumRequestDto, Stadium>,
        ResponseDtoMapper<StadiumResponseDto, Stadium> {
    @Override
    public Stadium mapToModel(StadiumRequestDto dto) {
        Stadium stadium = new Stadium();
        stadium.setDescription(dto.getDescription());
        stadium.setCapacity(dto.getCapacity());
        return stadium;
    }

    @Override
    public StadiumResponseDto mapToDto(Stadium stadium) {
        StadiumResponseDto responseDto = new StadiumResponseDto();
        responseDto.setId(stadium.getId());
        responseDto.setCapacity(stadium.getCapacity());
        responseDto.setDescription(stadium.getDescription());
        return responseDto;
    }
}
