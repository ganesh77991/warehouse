package com.app.service;

import java.util.List;

import com.app.model.Uom;

public interface IUomService {

	public Integer createUom(Uom uom);

	public List<Uom> getAllUoms();

	public Uom getOneUomById(Integer uomId);

	public void deleteUom(Integer uomId);

	public void updateUom(Uom uom);

	public boolean isUomModelExist(String model);
}
