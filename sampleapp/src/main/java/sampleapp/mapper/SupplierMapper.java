package sampleapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import sampleapp.entity.Supplier;

@Mapper
public interface SupplierMapper {

    List<Supplier> getAllSuppliers();

    Supplier getSupplierById(int id);

    void addSupplier(Supplier supplier);

    void updateSupplier(Supplier supplier);

    void deleteSupplier(int id);
}
