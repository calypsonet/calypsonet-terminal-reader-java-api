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
 * Interface that provides the methods related to the configuration of communication protocols for a
 * specific Card Reader instance
 *
 * @since 1.0.0
 */
public interface ConfigurableCardReader extends CardReader {

  /**
   * Activates the reader communication protocol by associating the provided reader communication
   * protocol name and the communication protocol name defined by the application.
   *
   * <ul>
   *   <li>Activates the detection of cards using the provided reader communication protocol.
   *   <li>Internally associates the two strings provided as arguments.
   * </ul>
   *
   * <p>The association between the communication protocol name known by the reader and the
   * communication protocol name defined by the application is intended to manage non-ISO cards. It
   * allows a unique protocol name to be set when constructing a card selector as defined by the
   * <b>Terminal Card API</b> regardless of the type of reader that will be used.
   *
   * @param readerProtocol The name of the communication protocol as known by the reader. See the
   *     reader documentation for the list of supported communication protocols.
   * @param cardProtocol The name of the communication protocol of the card which be detect as
   *     defined by the application.
   * @throws IllegalArgumentException If one of the provided communication protocols is null or
   *     empty.
   * @throws ReaderProtocolNotSupportedException If the reader communication protocol is not
   *     supported.
   * @since 1.0.0
   */
  void activateProtocol(String readerProtocol, String cardProtocol);

  /**
   * Deactivates the provided reader communication protocol. Inhibits the detection of cards using
   * this reader communication protocol.
   *
   * @param readerProtocol The name of the communication protocol as known by the reader. See the
   *     reader documentation for the list of supported communication protocols.
   * @throws IllegalArgumentException If the provided reader communication protocol is null or
   *     empty.
   * @throws ReaderProtocolNotSupportedException If the reader communication protocol is not
   *     supported.
   * @since 1.0.0
   */
  void deactivateProtocol(String readerProtocol);
}
