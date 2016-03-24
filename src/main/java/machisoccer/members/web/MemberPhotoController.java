package machisoccer.members.web;

import lombok.Data;
import machisoccer.members.models.Grade;
import machisoccer.members.models.MemberPhoto;
import machisoccer.members.services.MemberPhotoService;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class MemberPhotoController {
  private final MemberPhotoService memberPhotoService;

  @Autowired
  public MemberPhotoController(MemberPhotoService memberPhotoService) {
    this.memberPhotoService = memberPhotoService;
  }

  @RequestMapping("/members")
  public String listMemberPhotos(@Validated @ModelAttribute SearchMemberForm form,
                                 Model model,
                                 BindingResult result) {
    if(result.hasErrors()) {
      // todo: fix /error in case here.
      model.addAttribute("members", Collections.EMPTY_LIST);
      return "members";
    }

    model.addAttribute("members", memberPhotoService.getMemberPhotos(form.grades));
    return "members";
  }

  @Data
  private static class SearchMemberForm {
    @NotEmpty
    private List<Grade> grades = Arrays.asList(Grade.values());
  }
}
