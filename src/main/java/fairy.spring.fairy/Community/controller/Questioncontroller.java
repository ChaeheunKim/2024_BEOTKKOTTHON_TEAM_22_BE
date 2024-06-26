package fairy.spring.fairy.Community.controller;

import fairy.spring.fairy.Community.Request.CommunityRequest;
import fairy.spring.fairy.Community.Response.CommunityResponse;
import fairy.spring.fairy.Community.Service.Questionservice;
import fairy.spring.fairy.Community.domain.Question;
import fairy.spring.fairy.config.utils.ApiResponseBuilder;
import fairy.spring.fairy.user.response.MypageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name="Question", description = "질문 api")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Questioncontroller {

    private final Questionservice questionservice;

    @Operation(summary = "질문 등록", description = "질문을 등록합니다.")
    @ApiResponse(responseCode = "200", description = "질문 등록 성공",
            content = @Content(mediaType = "application/json"))
    @PostMapping(value = "/community/question")
    public ResponseEntity<?> createQuestion(@RequestBody @Valid CommunityRequest.questionRequestDTO questionRequestDTO) {
        CommunityResponse.questionResponseDTO questionResponseDTO = questionservice.createQuestion(questionRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseBuilder.success(questionResponseDTO));
    }




    @Operation(summary = "질문 수정", description = "질문을 수정합니다.")
    @ApiResponse(responseCode = "200", description = "질문 수정 성공")
    @PatchMapping("/community/question/{question_id}")
    public ResponseEntity<?> update(@PathVariable("question_id") Long question_id, CommunityRequest.questionRequestDTO questionRequestDTO) {
        CommunityResponse.questionResponseDTO questionResponseDTO = questionservice.updateById(question_id,questionRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseBuilder.successWithNoContent());
    }

    @Operation(summary = "질문 전체 조회", description = "질문전체를 조회합니다.")
    @ApiResponse(responseCode = "200", description = "질문 조회 성공")
    @GetMapping("/community/items")
    public ResponseEntity<?> viewQuestion(){
        CommunityResponse.viewquestionResponseDTO viewquestionResponseDTO =questionservice.searchAll();
        return  ResponseEntity.status(HttpStatus.OK).body(ApiResponseBuilder.success(viewquestionResponseDTO));
    }


}
