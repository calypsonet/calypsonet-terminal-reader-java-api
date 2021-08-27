/* **************************************************************************************
 * Copyright (c) 2021 Calypso Networks Association https://calypsonet.org/
 *
 * See the NOTICE file(s) distributed with this work for additional information
 * regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License 2.0 which is available at http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 ************************************************************************************** */
package org.calypsonet.terminal.reader;

/**
 * Interface that provides the methods related to the configuration of communication protocols 
 * for a specific Card Reader instance
 *
 * @since 1.0.0
 */
public interface ConfigurableCardReader extends CardReader {

  /**
   * Activates the reader communication protocol by associating the provided reader communication 
   * protocol name and the protocol name defined by the application.
   *
   * <ul>
   *   <li>Activates the detection of cards using the provided reader communication protocol.
   *   <li>Asks the reader to accept any card using this communication protocol during the selection 
   *       phase.
   *   <li>Internally associates the two strings provided as arguments.
   * </ul>
   *
   * <p>The association between the communication protocol name known by the reader and the 
   * communication protocol name known by the application is intended to allow a unique protocol 
   * name to be set when constructing a card selector as defined by the <b>Terminal Card API</b>
   * regardless of the type of reader that will be used.
   *
   * @param readerProtocol The name of the communication protocol as known by the reader.
   * @param cardProtocol The name of the communication protocol as known by the application.
   * @throws IllegalArgumentException If one of the provided communication protocol is null or empty.
   * @throws ReaderProtocolNotSupportedException If the communication protocol is not supported.
   * @since 1.0.0
   */
  void activateProtocol(String readerProtocol, String cardProtocol);

  /**
   * Deactivates the provided card communication protocol.
   *
   * <ul>
   *   <li>Inhibits the detection of cards using this communication protocol.
   *   <li>Ask the reader to ignore this protocol if a card using this communication 
   *       protocol is identified during the selection phase.
   * </ul>
   *
   * @param readerProtocol The name of the communication protocol as known by the reader.
   * @throws IllegalArgumentException If the provided communication protocol is null or empty.
   * @throws ReaderProtocolNotSupportedException If the communication protocol is not supported.
   * @since 1.0.0
   */
  void deactivateProtocol(String readerProtocol);
}
