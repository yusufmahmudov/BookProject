package online.bookStore.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import lombok.RequiredArgsConstructor;
import online.bookStore.dto.ResponseDto;
import online.bookStore.dto.UserAddressDto;
import online.bookStore.service.UserAddressService;
import online.bookStore.service.jsonBuilder.Distance;
import online.bookStore.service.jsonBuilder.Element;
import online.bookStore.service.jsonBuilder.JsonBody;
import online.bookStore.service.jsonBuilder.JsonRow;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersAddressServiceImpl implements UserAddressService {

    @Override
    public ResponseDto<List<UserAddressDto>> getAllUsersAddresses() {
        return null;
    }

    @Override
    public ResponseDto<UserAddressDto> getById(Integer id) {
        return null;
    }

    @Override
    public ResponseDto add(UserAddressDto dto) {
        return null;
    }

    @Override
    public ResponseDto update(UserAddressDto dto) {
        return null;
    }

    @Override
    public ResponseDto delete(Integer id) {
        return null;
    }


    @Override
    public Integer getDistanceBetweenTwoAddress(String address) {

        String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" +
                "Washington%2C%20DC&destinations="+address+"%2C%20NY&units=" +
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
        JsonRow jsonRow = jsonBody.getJsonRows().get(0);
        Element element = jsonRow.getElementList().get(0);
        Distance distance = element.getDistance();

        Integer distanceBetweenTwoAddresses = distance.getValue();

        return distanceBetweenTwoAddresses;
    }
}
