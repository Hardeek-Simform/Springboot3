package com.practical3.vehicleregistory.service;

import com.practical3.vehicleregistory.entity.RegistryMember;
import com.practical3.vehicleregistory.entity.UserVehicle;
import com.practical3.vehicleregistory.entity.dto.UserDTO;
import com.practical3.vehicleregistory.entity.dto.mapper.UserDTOMapper;
import com.practical3.vehicleregistory.entity.dto.mapper.UserDTOToUserVehicleMapper;
import com.practical3.vehicleregistory.repository.UserVehicleRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserService {
    private static final ArrayList<RegistryMember> registryMembers = new ArrayList<>();

    static {
        registryMembers.add(new RegistryMember(51, "Rakesh"));
        registryMembers.add(new RegistryMember(52, "Suresh"));
        registryMembers.add(new RegistryMember(53, "Mahesh"));
    }

    @Autowired
    private UserDTOToUserVehicleMapper userDTOToUserVehicleMapper;
    @Autowired
    private UserDTOMapper userDTOMapper;

    public ArrayList<UserDTO> addData(UserDTO userDTO) {
        // added dto objects in the UserVehicle entity
        UserVehicle vehicle = userDTOToUserVehicleMapper.apply(userDTO);
        int index = (int) (Math.random() * registryMembers.size());
        log.info("Registry index value:" + index);
        vehicle.setRegistryId(registryMembers.get(index).getRegistryId());
        vehicle.setRegistryName(registryMembers.get(index).getRegistryName());

        // fetching arraylist and pushing the data
        ArrayList<UserVehicle> usersVehList = UserVehicleRepo.getUsersVehList();
        usersVehList.add(vehicle);
        log.info("Vehicle details pushed:" + vehicle);
        UserVehicleRepo.setUsersVehList(usersVehList);
        return (ArrayList<UserDTO>) usersVehList.stream().map(userDTOMapper).collect(Collectors.toList());
    }

    public ArrayList<UserDTO> getAllUserVehicles() {
        return (ArrayList<UserDTO>) UserVehicleRepo.getUsersVehList().stream().map(userDTOMapper).collect(Collectors.toList());
    }

    public UserDTO getSelectedUserVehicle(int billNo) {
        Optional<UserVehicle> optionalUserDTO = UserVehicleRepo.getUsersVehList().stream().filter(user -> user.getBillNo() == billNo).findFirst();
        if (optionalUserDTO.isPresent()) {
            UserVehicle vehicle = optionalUserDTO.get();
            UserDTO userDTO = userDTOMapper.apply(vehicle);
            return userDTO;
        } else {
            return null;
        }
    }
}