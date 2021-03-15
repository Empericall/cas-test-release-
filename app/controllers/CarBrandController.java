package controllers;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import model.dto.CarBrandDto;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.libs.exception.ExceptionUtils;
import play.mvc.Controller;
import play.mvc.Result;
import service.CarBrandsService;

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
@Api(value = "Car Brands Controller", produces = "application/json")
public class CarBrandController extends Controller {
	
	private final CarBrandsService carBrandsService;
	private final HttpExecutionContext executionContext;

	@ApiOperation(value = "Получить по ID", response = CarBrandDto.class)
	public CompletionStage<Result> getById(@ApiParam(value = "ID") Optional<Long> id) {
		return carBrandsService.getById(id.get())
				.thenApplyAsync(e -> ok(Json.toJson(e)), executionContext.current());
	}

	@ApiOperation(value = "Получить все позиции", response = CarBrandDto[].class)
	public CompletionStage<Result> getAll() {
		return carBrandsService.getAll()
				.thenApplyAsync(e -> ok(Json.toJson(e)), executionContext.current());
	}

	@ApiOperation(value = "Сохранить данные")
	@ApiImplicitParams({
			@ApiImplicitParam(
					value = "CarBrandDto",
					name = "body",
					paramType = "body",
					dataType = "model.dto.CarBrandDto",
					required = true
			)
	})
	public CompletionStage<Result> save() {
		CarBrandDto carForSale = Json.fromJson(request().body().asJson(), CarBrandDto.class);
		return result(carBrandsService.save(carForSale));
	}

	@ApiOperation(value = "Обновить данные")
	@ApiImplicitParams({
			@ApiImplicitParam(
					value = "CarBrandDto",
					name = "body",
					paramType = "body",
					dataType = "model.dto.CarBrandDto",
					required = true
			)
	})
	public CompletionStage<Result> update() {
		CarBrandDto carForSale = Json.fromJson(request().body().asJson(), CarBrandDto.class);
		return result(carBrandsService.update(carForSale));
	}

	@ApiOperation(value = "Удалить данные")
	@ApiImplicitParams({
			@ApiImplicitParam(
					value = "CarBrandDto",
					name = "body",
					paramType = "body",
					dataType = "model.dto.CarBrandDto",
					required = true
			)
	})
	public CompletionStage<Result> delete() {
		CarBrandDto carForSale = Json.fromJson(request().body().asJson(), CarBrandDto.class);
		return result(carBrandsService.delete(carForSale));
	}

	private CompletionStage<Result> result(CompletionStage<?> cs) {
		return cs.thenApplyAsync(empty -> (Result) ok(), executionContext.current())
				.exceptionally(e -> badRequest(ExceptionUtils.getStackTrace(e)));
	}
}
