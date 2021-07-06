package spring.web.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import lombok.extern.java.Log;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.web.dto.request.MatchRequestDto;
import spring.web.dto.response.MatchResponseDto;
import spring.web.model.Match;
import spring.web.service.MatchService;
import spring.web.service.mapper.MatchMapper;
import spring.web.util.DateTimePatternUtil;

@Log
@RestController
@RequestMapping("/matches")
public class MatchController {
    public static final String DATE_PATTERN = DateTimePatternUtil.DATE_PATTERN;
    private final MatchService matchService;
    private final MatchMapper matchMapper;

    public MatchController(MatchService matchService,
                           MatchMapper matchMapper) {
        this.matchService = matchService;
        this.matchMapper = matchMapper;
    }

    @PostMapping
    public MatchResponseDto add(@RequestBody @Valid MatchRequestDto requestDto) {
        Match match = matchMapper.mapToModel(requestDto);
        matchService.add(match);
        log.info("new entity:match was added to db");
        return matchMapper.mapToDto(match);
    }

    @GetMapping("/available")
    public List<MatchResponseDto> getAll(@RequestParam @Min(1) Long gameId,
            @RequestParam @DateTimeFormat(pattern = DATE_PATTERN) LocalDate date) {
        log.info("all available matches was fetched from db");
        return matchService.findAvailableMatches(gameId, date)
                .stream()
                .map(matchMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public MatchResponseDto update(@PathVariable @Min(1) Long id,
                                   @RequestBody @Valid MatchRequestDto requestDto) {
        Match match = matchMapper.mapToModel(requestDto);
        match.setId(id);
        matchService.update(match);
        log.info("entity:match was updated");
        return matchMapper.mapToDto(match);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable @Min(1) Long id) {
        matchService.delete(id);
        log.info("entity:match was deleted");
    }
}
