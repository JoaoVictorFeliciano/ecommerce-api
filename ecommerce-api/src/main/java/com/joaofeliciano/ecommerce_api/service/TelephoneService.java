package com.joaofeliciano.ecommerce_api.service;

import com.joaofeliciano.ecommerce_api.dto.TelephoneRequestDto;
import com.joaofeliciano.ecommerce_api.dto.TelephoneResponseDto;
import com.joaofeliciano.ecommerce_api.entity.Telephone;
import com.joaofeliciano.ecommerce_api.exception.InvalidId;
import com.joaofeliciano.ecommerce_api.exception.InvalidNumber;
import com.joaofeliciano.ecommerce_api.exception.InvalidUser;
import com.joaofeliciano.ecommerce_api.repository.TelephoneRepository;
import com.joaofeliciano.ecommerce_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TelephoneService {

    private final TelephoneRepository telephoneRepository;
    private final UserRepository userRepository;

    @Autowired
    public TelephoneService(TelephoneRepository telephoneRepository, UserRepository userRepository) {
        this.telephoneRepository = telephoneRepository;
        this.userRepository = userRepository;
    }

    private Telephone toEntity(TelephoneRequestDto dto) {
        Telephone telephone = new Telephone();
        telephone.setNumberPhone(dto.getNumberPhone());
        return telephone;
    }

    private TelephoneResponseDto toResponseDto(Telephone telephone) {
        return new TelephoneResponseDto(
                telephone.getIdTelephone(),
                telephone.getNumberPhone()
        );
    }

    public TelephoneResponseDto createTelephone(TelephoneRequestDto dto) throws InvalidNumber {
        if (!userRepository.existsById(dto.getIdUser())) {
            throw new InvalidNumber("Id User not found.");
        }
        Telephone telephone = toEntity(dto);
        Telephone saved = telephoneRepository.save(telephone);
        return toResponseDto(saved);
    }

    public TelephoneResponseDto findById(Long id) throws InvalidId {
        if (!telephoneRepository.existsById(id)) {
            throw new InvalidId("Id invalid.");
        }
        Telephone telephone = telephoneRepository.findById(id)
                .orElseThrow(() -> new InvalidId("Id not found."));
        return toResponseDto(telephone);
    }

    public List<TelephoneResponseDto> findAll() {
        return telephoneRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    public TelephoneResponseDto updateTelephone(Long id, TelephoneRequestDto dto) throws InvalidUser {
        if (!telephoneRepository.existsById(dto.getIdUser())) {
            throw new InvalidUser("User invalid.");
        }

        Telephone telephone = telephoneRepository.findById(id)
                .orElseThrow(() -> new InvalidUser("User not found."));

        telephone.setNumberPhone(dto.getNumberPhone());
        Telephone updated = telephoneRepository.save(telephone);
        return toResponseDto(updated);
    }

    public void deleteTelephone(Long id) throws InvalidId{
        Telephone telephone = telephoneRepository.findById(id)
                .orElseThrow(() -> new InvalidId("Invalid Id."));
        telephoneRepository.delete(telephone);
    }
}