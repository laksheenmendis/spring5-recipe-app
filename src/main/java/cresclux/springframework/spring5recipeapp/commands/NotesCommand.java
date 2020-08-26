package cresclux.springframework.spring5recipeapp.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by laksheenmendis on 8/25/20 at 9:29 PM
 */
@Setter
@Getter
@NoArgsConstructor
public class NotesCommand {
    private Long id;
    private String recipeNotes;
}


