package com.fastporte.fastportewebservice.service.impl;


import com.fastporte.fastportewebservice.entities.Vehicle;
import com.fastporte.fastportewebservice.repository.IVehicleRepository;
import com.fastporte.fastportewebservice.service.IVehicleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class VehicleServiceImpl implements IVehicleService {

    private final IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(IVehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    @Transactional
    public Vehicle save(Vehicle vehicle) throws Exception {
        return vehicleRepository.save(vehicle);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        vehicleRepository.deleteById(id);
    }

    @Override
    public List<Vehicle> findByDriverId(Long driverId) throws Exception {
        return vehicleRepository.findByDriverId(driverId);
    }

    @Override
    public List<Vehicle> getAll() throws Exception {
        return vehicleRepository.findAll();
    }

    @Override
    public Optional<Vehicle> getById(Long id) throws Exception {
        return vehicleRepository.findById(id);
    }

    @Override
    public List<Vehicle> getByBoxMeasure(Float width, Float height, Float length, Integer boxes) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<Vehicle> vehiclesFiltered = new ArrayList<>();

        Double boxVolume = (double) (width * height * length);
        Double boxesVolume = boxVolume * boxes;

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getDimensionWidth() == null) continue;

            Integer maxBoxesWidthAmount = (int) (vehicle.getDimensionWidth() / width);
            Integer maxBoxesHeightAmount = (int) (vehicle.getDimensionHeight() / height);
            Integer maxBoxesLengthAmount = (int) (vehicle.getDimensionLength() / length);

            Integer maxBoxesVolumeAmount = (maxBoxesWidthAmount * maxBoxesHeightAmount * maxBoxesLengthAmount);

            if ((maxBoxesVolumeAmount * boxVolume) >= boxesVolume) {
                vehiclesFiltered.add(vehicle);
            }
        }

        return vehiclesFiltered;
    }

    //@Override
    //public List<Vehicle> finByType_cardQuantityCategory(String type_card, Long quantity, String category) {
    //    return vehicleRepository.finByType_cardQuantityCategory(type_card,quantity,category);
    //}
}
