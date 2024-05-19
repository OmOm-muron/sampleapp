package sampleapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sampleapp.entity.Supplier;
import sampleapp.mapper.SupplierMapper;

@Service
public class SupplierService {

    private final SupplierMapper supplierMapper;

    public SupplierService(SupplierMapper supplierMapper) {
        this.supplierMapper = supplierMapper;
    }

    public List<Supplier> getAllSuppliers() {
        return supplierMapper.getAllSuppliers();
    }

    public Supplier getSupplierById(int id) {
        return supplierMapper.getSupplierById(id);
    }

    public void addSupplier(Supplier supplier) {
        supplierMapper.addSupplier(supplier);
    }

    public void updateSupplier(Supplier supplier) {
        supplierMapper.updateSupplier(supplier);
    }

    public void deleteSupplier(int id) {
        supplierMapper.deleteSupplier(id);
    }
}
