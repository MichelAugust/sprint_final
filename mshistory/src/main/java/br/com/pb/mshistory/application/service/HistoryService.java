package br.com.pb.mshistory.application.service;

import br.com.pb.mshistory.domain.dto.HistoryDTO;
import br.com.pb.mshistory.domain.model.History;
import br.com.pb.mshistory.framework.out.database.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HistoryService {

    private final HistoryRepository repository;
    private final ModelMapper mapper;

    public List<HistoryDTO> getAll(LocalDate date){
        List<History> historyList = repository.getByDate(date);
        return historyList.stream().map(history -> mapper.map(history, HistoryDTO.class)).collect(Collectors.toList());
    }

    public List<HistoryDTO> getAllDate(LocalDate start, LocalDate end){
        List<History> h = repository.getByDate(start, end);
        return h.stream().map(history -> mapper.map(history, HistoryDTO.class)).collect(Collectors.toList());
    }

    public List<HistoryDTO> verify(LocalDate date, LocalDate start){
        if(start == null || date == null){
            return getAll(date);
        }else{
            return getAllDate(start, date);
        }
    }

}


