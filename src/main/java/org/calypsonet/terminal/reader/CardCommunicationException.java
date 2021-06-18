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
 * Indicates that the communication with the card failed.
 *
 * <p>The most likely reason is that the card was removed from the reader during the exchange, but
 * other technical problems may also be the origin of the failure.
 *
 * @since 1.0
 */
public class CardCommunicationException extends RuntimeException {

  /**
   * @param message The message to identify the exception context.
   * @since 1.0
   */
  public CardCommunicationException(String message) {
    super(message);
  }

  /**
   * @param message The message to identify the exception context.
   * @param cause The cause.
   * @since 1.0
   */
  public CardCommunicationException(String message, Throwable cause) {
    super(message, cause);
  }
}
