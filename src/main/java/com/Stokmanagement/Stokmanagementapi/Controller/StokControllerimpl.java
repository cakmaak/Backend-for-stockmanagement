package com.Stokmanagement.Stokmanagementapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@PostMapping("/savestok/{productid}")
	@Override
	public Stok saveStokHistory(@RequestBody Stok stokhistory,@PathVariable Long productid) {
		
		return stokService.saveStokHistory(stokhistory, productid);
	}
	
	@GetMapping("/getallstockhistory")
	@Override
	public List<Stok> getallstokhistory() {
		
		return stokService.getallstokhistory();
	}

}
