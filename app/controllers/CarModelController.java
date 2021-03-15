package controllers;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.dto.CarModelDto;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.libs.exception.ExceptionUtils;
import play.mvc.Controller;
import play.mvc.Result;
import service.CarModelsService;

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
@Api(value = "Car Models Controller", produces = "application/json")
public class CarModelController extends Controller {

	private final CarModelsService carModelsService;
	private final HttpExecutionContext executionContext;

	@ApiOperation(value = "Получить по ID", response = CarModelDto.class)
	public CompletionStage<Result> getById(@ApiParam(value = "ID") Optional<Long> id) {
		return carModelsService.getById(id.get())
				.thenApplyAsync(e -> ok(Json.toJson(e)), executionContext.current());
	}

	@ApiOperation(value = "Получить все позиции", response = CarModelDto[].class)
	public CompletionStage<Result> getAll() {
		return carModelsService.getAll()
				.thenApplyAsync(e -> ok(Json.toJson(e)), executionContext.current());
	}

	@ApiOperation(value = "Сохранить данные")
	@ApiImplicitParams({
			@ApiImplicitParam(
					value = "CarModelDto",
					name = "body",
					paramType = "body",
					dataType = "model.dto.CarModelDto",
					required = true
			)
	})
	public CompletionStage<Result> save() {
		CarModelDto carForSale = Json.fromJson(request().body().asJson(), CarModelDto.class);
		return result(carModelsService.save(carForSale));
	}

	@ApiOperation(value = "Обновить данные")
	@ApiImplicitParams({
			@ApiImplicitParam(
					value = "CarModelDto",
					name = "body",
					paramType = "body",
					dataType = "model.dto.CarModelDto",
					required = true
			)
	})
	public CompletionStage<Result> update() {
		CarModelDto carForSale = Json.fromJson(request().body().asJson(), CarModelDto.class);
		return result(carModelsService.update(carForSale));
	}

	@ApiOperation(value = "Удалить данные")
	@ApiImplicitParams({
			@ApiImplicitParam(
					value = "CarModelDto",
					name = "body",
					paramType = "body",
					dataType = "model.dto.CarModelDto",
					required = true
			)
	})
	public CompletionStage<Result> delete() {
		CarModelDto carForSale = Json.fromJson(request().body().asJson(), CarModelDto.class);
		return result(carModelsService.delete(carForSale));
	}

	private CompletionStage<Result> result(CompletionStage<?> cs) {
		return cs.thenApplyAsync(empty -> (Result) ok(), executionContext.current())
				.exceptionally(e -> badRequest(ExceptionUtils.getStackTrace(e)));
	}
}
