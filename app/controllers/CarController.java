package controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.dto.CarForSaleDto;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;
import service.CarsShopService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;
import java.util.concurrent.CompletionStage;

/**
 * @author Emperical
 * */
@Slf4j
@Singleton
@RequiredArgsConstructor(onConstructor_ = { @Inject })
@Api(value = "Car Controller", produces = "application/json")
public class CarController extends Controller {

	private final CarsShopService carsShopService;
	private final HttpExecutionContext executionContext;

	@ApiOperation(value = "Получить по ID", response = CarForSaleDto.class)
	public CompletionStage<Result> getById(@ApiParam(value = "ID") Optional<Long> id) {
		return carsShopService.getById(id.get())
				.thenApplyAsync(e -> ok(Json.toJson(e)), executionContext.current());
	}


}
