/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dal.DAOInterface;

import model.Media;

/**
 *
 * @author ACER
 */
public interface IMediaDAO extends IDAO<Media> {

    Media get(String link);

    int uploadVideo(Media g);

    int uploadDemo(Media g);
}
