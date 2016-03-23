package machisoccer.members.web;

import machisoccer.members.services.MemberPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberPhotoController {
  private final MemberPhotoService memberPhotoService;

  @Autowired
  public MemberPhotoController(MemberPhotoService memberPhotoService) {
    this.memberPhotoService = memberPhotoService;
  }

  @RequestMapping("/members")
  public String listMemberPhotos(Model model) {
    model.addAttribute("members", memberPhotoService.getMemberPhotos());
    return "members";
  }
}
