package com.Stokmanagement.Stokmanagementapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Stokmanagement.Stokmanagementapi.Entity.Stok;
import com.Stokmanagement.Stokmanagementapi.Service.IStokService;

@RestController
@RequestMapping("/stokman/stok")
public class StokControllerimpl implements IStokController {
	@Autowired
	IStokService stokService;
	
	@PostMapping("/savestok")
	@Override
	public Stok saveStokHistory(@RequestBody Stok stokhistory,Long productid) {
		
		return stokService.saveStokHistory(stokhistory,productid);
	}

}
