package br.com.pb.compass.msorder.service;

import br.com.pb.compass.msorder.domain.dto.ItemDTO;
import br.com.pb.compass.msorder.domain.dto.request.ItemRequest;
import br.com.pb.compass.msorder.domain.model.Item;
import br.com.pb.compass.msorder.repository.ItemRepository;
import br.com.pb.compass.msorder.util.MappersUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository repository;
    private final MappersUtils mapperUtils;
    private final ModelMapper mapper;

    public ItemDTO updateItemById(long id, ItemRequest request) {
        Item item = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Item newItem = mapperUtils.itemRequestToEntity(request);

        mapper.map(newItem, item);
        repository.save(item);

        return mapper.map(item, ItemDTO.class);
    }

}
