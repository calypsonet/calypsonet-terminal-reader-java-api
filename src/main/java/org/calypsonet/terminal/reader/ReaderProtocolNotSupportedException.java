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
 * Indicates that the current card protocol is not supported by the reader.
 *
 * @since 1.0.0
 */
public class ReaderProtocolNotSupportedException extends RuntimeException {

  /**
   * @param cardProtocol The identification data used to identify the card.
   * @since 1.0.0
   */
  public ReaderProtocolNotSupportedException(String cardProtocol) {
    super("The card protocol " + cardProtocol + " is not supported.");
  }
}
