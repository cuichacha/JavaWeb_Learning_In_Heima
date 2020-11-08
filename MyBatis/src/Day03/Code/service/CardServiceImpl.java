package Day03.Code.service;

import Day03.Code.bean.Card;
import Day03.Code.mapper.CardMapper;
import Day03.Code.utils.MapperUtil;

import java.util.List;

public class CardServiceImpl implements CardService {
    @Override
    public List<Card> findAll() {
        CardMapper mapper = MapperUtil.getMapper(CardMapper.class, true);
        List<Card> cards = mapper.findAll();
        MapperUtil.close();
        return cards;
    }
}
