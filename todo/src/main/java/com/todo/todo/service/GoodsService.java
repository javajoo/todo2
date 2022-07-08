package com.todo.todo.service;

import com.todo.todo.entity.Goods;
import com.todo.todo.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class GoodsService {

    private final GoodsRepository goodsRepository;

    //등록(데이터가 없다면 insert)
    public void register(Goods goods) {
        goodsRepository.save(goods);
    }

    //조회
    public List<Goods> list() {
        return goodsRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    //상세조회(findById가 optional로 감싸져 있는 것을 바로 쓰기 위해 orElseThrow를 줌)
    public Goods detail(Long id) {
        return goodsRepository.findById(id).orElseThrow(EntityExistsException::new);
    }

    //수정(데이터가 있다면 update)
    public void update(Goods afterGoods) {
        Goods beforeGoods = goodsRepository.findById(afterGoods.getId()).orElseThrow(EntityExistsException::new);

        Goods change = beforeGoods.changeGoods(afterGoods);
        goodsRepository.save(change);
    }

    //삭제
    public void delete(Long id) {
        goodsRepository.deleteById(id);
    }

}