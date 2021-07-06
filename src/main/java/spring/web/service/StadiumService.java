package spring.web.service;

import java.util.List;
import spring.web.model.Stadium;

public interface StadiumService {
    Stadium add(Stadium stadium);

    Stadium get(Long id);

    List<Stadium> getAll();
}
