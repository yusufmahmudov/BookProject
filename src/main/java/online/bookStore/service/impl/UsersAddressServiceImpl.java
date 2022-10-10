package online.bookStore.service.impl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import lombok.RequiredArgsConstructor;
import online.bookStore.dto.ResponseDto;
import online.bookStore.dto.UserAddressDto;
import online.bookStore.entity.UserAddress;
import online.bookStore.repository.UserAddressRepository;
import online.bookStore.service.UserAddressService;
import online.bookStore.service.jsonBuilder.Distance;
import online.bookStore.service.jsonBuilder.Element;
import online.bookStore.service.jsonBuilder.JsonBody;
import online.bookStore.service.jsonBuilder.JsonRow;
import online.bookStore.service.mapper.UserAddressMapper;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersAddressServiceImpl implements UserAddressService {
    private final UserAddressRepository repository;
    private final UserAddressMapper mapper;
    @Override
    public ResponseDto<List<UserAddressDto>> getAllUsersAddresses() {
        List<UserAddress> addressList = repository.findAll();
        List<UserAddressDto> userAddressDtos = addressList.stream()
                .map(mapper::toDto)
                .toList();
        return ResponseDto.<List<UserAddressDto>>builder()
                .code(200)
                .success(true)
                .message("OK")
                .data(userAddressDtos)
                .build();
    }

    @Override
    public ResponseDto<UserAddressDto> getById(Integer id) {
        if (repository.existsById(id)){
            UserAddress userAddress = repository.findById(id).get();
            UserAddressDto dto = mapper.toDto(userAddress);

            return ResponseDto.<UserAddressDto>builder()
                    .code(200)
                    .success(true)
                    .message("OK")
                    .data(dto)
                    .build();
        }
        return ResponseDto.<UserAddressDto>builder()
                .code(-3)
                .success(false)
                .message("Doesn't exists")
                .build();
    }

    @Override
    public ResponseDto add(String address, UserAddressDto dto){
        UserAddress userAddress = mapper.toEntity(dto);
        System.out.println(userAddress);
        Integer distanceFromBookstore = getDistanceBetweenTwoAddress(address);
        userAddress.setDistanceFromBookstore(distanceFromBookstore);

        repository.save(userAddress);

        return ResponseDto.builder()
                .code(200)
                .success(true)
                .message("Successfully saved")
                .build();
    }

    @Override
    public ResponseDto update(UserAddressDto dto) {
        if (repository.existsById(dto.getId())){
            UserAddress userAddress = mapper.toEntity(dto);
            repository.save(userAddress);

            return ResponseDto.builder()
                    .code(200)
                    .success(true)
                    .message("Successfully updated")
                    .build();
        }

        return ResponseDto.builder()
                .code(-3)
                .success(false)
                .message("Doesn't exists")
                .build();

    }

    @Override
    public ResponseDto delete(Integer id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return ResponseDto.builder()
                    .code(200)
                    .success(true)
                    .message("Successfully deleted")
                    .build();
        }

        return ResponseDto.builder()
                .code(-3)
                .success(false)
                .message("Doesn't exists")
                .build();
    }

    @Override
    public Integer getDistanceBetweenTwoAddress(String address) {
        String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" +
                "Tashkent&destinations= " + address + "&units=" +
                "imperial&key=AIzaSyAqlW-qCJmBGb1lF4vf6Q4sU1zxTcLZx50";

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
//                .addHeader("Accept", "application/json")
                .method("GET", null)
                .build();

        Response response;
        JsonBody jsonBody;

        try {
            response = client.newCall(request).execute();

            ResponseBody responseBody = response.body();
            byte [] body = responseBody.byteStream().readAllBytes();

            ObjectMapper objectMapper = new ObjectMapper();
            jsonBody = objectMapper.readValue(body, JsonBody.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        JsonRow jsonRow = jsonBody.getRows().get(0);
        Element element = jsonRow.getElements().get(0);
        Distance distance = element.getDistance();

        Integer distanceBetweenTwoAddresses = distance.getValue();
        return distanceBetweenTwoAddresses;
    }
}
