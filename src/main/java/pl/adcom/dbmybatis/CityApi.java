package pl.adcom.dbmybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityApi {

    private CityMapper cityMapper;

    @Autowired
    public CityApi(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    @GetMapping
    public List<City> getAllCities(){
        return cityMapper.findAll();
    }

    @GetMapping("/{id}")
    public City getCityById(@PathVariable Long id){
        return cityMapper.findById(id);
    }


    @PostMapping
    public void addCity(@RequestBody City city){
        cityMapper.insert(city);
    }
}
