/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.streichholzprojekt.server.enumeration;

/**
 *
 * @author pascal.wiedenbeck
 */
public enum MessageType {
    LOGIN,
    LOGOUT,
    CREATE_ROOM,
    JOIN_ROOM,
    LEAVE_ROOM,
    LIST_ROOMS,
    UNKOWN
}
