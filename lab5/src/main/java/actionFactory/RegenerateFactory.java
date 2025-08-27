/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package actionFactory;

import actions.Action;
import actions.RegenerateAction;

public class RegenerateFactory extends ActionFactory {

    @Override
    public Action createAction() {
        return new RegenerateAction();
    }
}
