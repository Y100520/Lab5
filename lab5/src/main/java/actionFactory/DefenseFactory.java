/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actionFactory;

import actions.*;

/**
 * Конретная фабрика для создания действия {@link Defense}
 * @author Yulov
 */
public class DefenseFactory extends ActionFactory{

    /**
     *
     * @return объект типа Action, соответствующий действию Defense
     */
    @Override
    public Action createAction() {
        return new Defense();
    }
}
