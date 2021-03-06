package controllers;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.dto.CarForSaleDto;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.libs.exception.ExceptionUtils;
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

	@ApiOperation(value = "Получить все позиции", response = CarForSaleDto[].class)
	public CompletionStage<Result> getAll() {
		return carsShopService.getAll()
				.thenApplyAsync(e -> ok(Json.toJson(e)), executionContext.current());
	}

	@ApiOperation(value = "Сохранить данные")
	@ApiImplicitParams({
			@ApiImplicitParam(
					value = "CarForSaleDto",
					name = "body",
					paramType = "body",
					dataType = "model.dto.CarForSaleDto",
					required = true
			)
	})
	public CompletionStage<Result> save() {
		CarForSaleDto carForSale = Json.fromJson(request().body().asJson(), CarForSaleDto.class);
		return result(carsShopService.save(carForSale));
	}

	@ApiOperation(value = "Обновить данные")
	@ApiImplicitParams({
			@ApiImplicitParam(
					value = "CarForSaleDto",
					name = "body",
					paramType = "body",
					dataType = "model.dto.CarForSaleDto",
					required = true
			)
	})
	public CompletionStage<Result> update() {
		CarForSaleDto carForSale = Json.fromJson(request().body().asJson(), CarForSaleDto.class);
		return result(carsShopService.update(carForSale));
	}

	@ApiOperation(value = "Удалить данные")
	@ApiImplicitParams({
			@ApiImplicitParam(
					value = "CarForSaleDto",
					name = "body",
					paramType = "body",
					dataType = "model.dto.CarForSaleDto",
					required = true
			)
	})
	public CompletionStage<Result> delete() {
		CarForSaleDto carForSale = Json.fromJson(request().body().asJson(), CarForSaleDto.class);
		return result(carsShopService.delete(carForSale));
	}

	private CompletionStage<Result> result(CompletionStage<?> cs) {
		return cs.thenApplyAsync(empty -> (Result) ok(), executionContext.current())
				.exceptionally(e -> {
					log.error("", e);
					return badRequest(ExceptionUtils.getStackTrace(e));
				});
	}
}
