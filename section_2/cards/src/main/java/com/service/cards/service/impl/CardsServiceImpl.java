package com.service.cards.service.impl;

import com.service.cards.constants.CardsConstants;
import com.service.cards.dto.CardsDto;
import com.service.cards.entity.Cards;
import com.service.cards.exception.CardAlreadyExistsException;
import com.service.cards.exception.ResourceNotFoundException;
import com.service.cards.mapper.CardsMapper;
import com.service.cards.repository.CardsRepository;
import com.service.cards.service.ICardsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardsServiceImpl implements ICardsService {

    private CardsRepository cardsRepository;

    @Override
    public void createCard(String mobileNumber) {
        Optional<Cards> optionalCards = cardsRepository.findByMobileNumber(mobileNumber);
        if (optionalCards.isPresent()) {
            throw new CardAlreadyExistsException("Card already registered with given mobileNumber " + mobileNumber);
        }
        Cards newCard = new Cards();
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setMobileNumber(mobileNumber);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setCardType(CardsConstants.CREDIT_CARD);
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        newCard.setAmountUsed(0);
        newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
        cardsRepository.save(newCard);
    }

    @Override
    public CardsDto fetchCard(String mobileNumber) {
        Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber)
        );
        return CardsMapper.mapToCardsDto(cards, new CardsDto());
    }

    @Override
    public boolean updateCard(CardsDto cardsDto) {
        boolean isUpdated = false;
        if (cardsDto != null) {
            Cards cards = cardsRepository.findByCardNumber(cardsDto.getCardNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Card", "CardNumber", cardsDto.getCardNumber())
            );
            CardsMapper.mapToCards(cardsDto, cards);
            cardsRepository.save(cards);
            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    public boolean deleteCard(String mobileNumber) {
        Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber)
        );
        cardsRepository.deleteById(cards.getCardId());
        return true;
    }
}
