package com.todo.todo.repository;

import com.todo.todo.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.OptionalInt;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
  //  Optional<Goods> findByGoodsIdAndGoodsName(String goodsId, String goodsName);

    Optional<Goods> findById(Long id);
}
