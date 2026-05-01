package com.joaofeliciano.ecommerce_api.service;

import com.joaofeliciano.ecommerce_api.dto.AddressRequestDto;
import com.joaofeliciano.ecommerce_api.dto.AddressResponseDto;
import com.joaofeliciano.ecommerce_api.entity.Address;
import com.joaofeliciano.ecommerce_api.exception.InvalidAddress;
import com.joaofeliciano.ecommerce_api.exception.InvalidId;
import com.joaofeliciano.ecommerce_api.repository.AddressRepository;
import com.joaofeliciano.ecommerce_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    private Address toEntity(AddressRequestDto dto){
        Address address = new Address();
        address.setCep(dto.getCep());
        address.setRoad(dto.getRoad());
        address.setHouseNumber(dto.getHouseNumber());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        return address;
    }

    private AddressResponseDto toResponseDto(Address address){
        return new AddressResponseDto(
                address.getIdAddress(),
                address.getCep(),
                address.getRoad(),
                address.getCity(),
                address.getState(),
                address.getHouseNumber()
        );
    }

    public AddressResponseDto createAddress(AddressRequestDto dto) throws InvalidAddress {
        if (!userRepository.existsById(dto.getIdUser())){
            throw new InvalidAddress("User not found.");
        }
        Address address = toEntity(dto);
        Address saved = addressRepository.save(address);
        return toResponseDto(saved);
    }

    public AddressResponseDto findById(Long id) throws InvalidId {
        if(!addressRepository.existsById(id)){
            throw new InvalidId("User not found.");
        }
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new InvalidId("Id not found."));
        return toResponseDto(address);
    }

    public List<AddressResponseDto> findAll(){
        return addressRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    public AddressResponseDto updateAddress(Long id, AddressRequestDto dto) throws InvalidAddress, InvalidId {
        if(!userRepository.existsById(dto.getIdUser())){
            throw new InvalidAddress("User not found.");
        }
        Address address = addressRepository.findById(id)
                .orElseThrow(()-> new InvalidId("Id not found"));

        address.setCep(dto.getCep());
        address.setRoad(dto.getRoad());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setHouseNumber(dto.getHouseNumber());
        Address updated = addressRepository.save(address);
        return toResponseDto(updated);
    }

    public void deleteAddress(Long id) throws InvalidId{
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new InvalidId("Id not found"));
        addressRepository.delete(address);
    }
}