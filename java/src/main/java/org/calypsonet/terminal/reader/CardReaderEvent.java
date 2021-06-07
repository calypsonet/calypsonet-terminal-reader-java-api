/* **************************************************************************************
 * Copyright (c) 2021 Calypso Networks Association https://www.calypsonet-asso.org/
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

import org.calypsonet.terminal.reader.selection.ScheduledCardSelectionsResponse;

/**
 * Card event data container indicating a change of state.
 *
 * <p>Contains the event origin (reader name), the event type and possibly the card selection
 * response in the case of {@link Type#CARD_INSERTED} or {@link Type#CARD_MATCHED} events.
 *
 * @since 1.0
 */
public interface CardReaderEvent {

  /**
   * Possible card events.
   *
   * @since 1.0
   */
  enum Type {

    /**
     * A card has been inserted with or without specific selection.
     *
     * @since 1.0
     */
    CARD_INSERTED,

    /**
     * A card has been inserted and matched the selection.
     *
     * @since 1.0
     */
    CARD_MATCHED,

    /**
     * The card has been removed from the reader.
     *
     * @since 1.0
     */
    CARD_REMOVED,

    /**
     * The reader has become unavailable.
     *
     * @since 1.0
     */
    UNAVAILABLE
  }

  /**
   * Gets the name of the reader that generated the event.
   *
   * @return A not empty string.
   * @since 1.0
   */
  String getReaderName();

  /**
   * Gets the reader event type.
   *
   * @return A not null value.
   * @since 1.0
   */
  Type getType();

  /**
   * Gets the card selection responses that may be present when the event is {@link
   * Type#CARD_INSERTED}, always present when the event is {@link Type#CARD_MATCHED} and null in the
   * others cases.
   *
   * @return Null if the event is not carrying a {@link ScheduledCardSelectionsResponse}.
   * @since 1.0
   */
  ScheduledCardSelectionsResponse getScheduledCardSelectionsResponse();
}
