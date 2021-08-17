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
 * Card reader driving the underlying hardware to manage the card detection.
 *
 * @since 1.0.0
 */
public interface CardReader {

  /**
   * Returns the name of the reader.
   *
   * @return A not empty string.
   * @since 1.0.0
   */
  String getName();

  /**
   * Tells if the card communication mode is contactless.
   *
   * @return True if the communication is contactless.
   * @since 1.0.0
   */
  boolean isContactless();

  /**
   * Checks if is the card present.
   *
   * @return True if a card is inserted in the reader.
   * @throws ReaderCommunicationException If the communication with the reader has failed.
   * @since 1.0.0
   */
  boolean isCardPresent();
}
