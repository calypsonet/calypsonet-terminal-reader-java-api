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
package org.calypsonet.terminal.reader.selection;

import org.calypsonet.terminal.reader.CardCommunicationException;
import org.calypsonet.terminal.reader.CardReader;
import org.calypsonet.terminal.reader.ObservableCardReader;
import org.calypsonet.terminal.reader.ReaderCommunicationException;
import org.calypsonet.terminal.reader.selection.spi.CardSelection;

/**
 * Service dedicated to card selection, based on the preparation of a card selection scenario.
 *
 * <p>A card selection scenario consists of one or more selection cases based on a {@link
 * CardSelection}.<br>
 * A card selection targets a specific card and defines optional commands to be executed after the
 * successful selection of the card. <br>
 * If a card selection case fails, the service will try with the next selection defined in the
 * scenario, if any. <br>
 * If a card selection case succeeds, the service will execute the next selection only if the
 * multiple selection mode is set (disabled by default).
 *
 * <p>This service allows to:
 *
 * <ul>
 *   <li>prepare the card selection scenario,
 *   <li>make an explicit selection of a card (when the card is already present),
 *   <li>to schedule the execution of the selection as soon as a card is presented to an observable
 *       reader.
 * </ul>
 *
 * <p>The logical channel established with the card can be left open (default) or closed after
 * selection.
 *
 * @since 1.0
 */
public interface CardSelectionService {

  /**
   * Sets the multiple selection mode to process all selection cases even in case of successful
   * selection.
   *
   * <p>The multiple selection mode is disabled by default.
   *
   * @since 1.0
   */
  void setMultipleSelectionMode();

  /**
   * Appends a card selection case to the card selection scenario.
   *
   * <p>The method returns the index giving the current position of the selection in the selection
   * scenario (0 for the first application, 1 for the second, etc.).
   *
   * @param cardSelection The card selection.
   * @return A positive int.
   * @since 1.0
   */
  int prepareSelection(CardSelection cardSelection);

  /**
   * Requests the closing of the physical channel at the end of the execution of the card selection
   * request.
   *
   * <p>It is thus possible to chain several selections on the same card selection scenario by
   * restarting the card connection sequence.
   *
   * @since 1.0
   */
  void prepareReleaseChannel();

  /**
   * Executes explicitly a previously prepared card selection scenario and returns the card
   * selection result.
   *
   * @param reader The reader to communicate with the card.
   * @return A not null reference.
   * @throws ReaderCommunicationException If the communication with the reader has failed.
   * @throws CardCommunicationException If communication with the card has failed or if the status
   *     word check is enabled in the card request and the card has returned an unexpected code.
   * @since 1.0
   */
  CardSelectionResult processCardSelectionScenario(CardReader reader);

  /**
   * Schedules the execution of the prepared card selection scenario as soon as a card is presented
   * to the provided {@link ObservableCardReader}.
   *
   * <p>{@link org.calypsonet.terminal.reader.CardReaderEvent} are notified to the observer
   * according to the specified notification mode.
   *
   * <p>The reader's behavior at the end of the card processing is defined by the specified {@link
   * ObservableCardReader.DetectionMode}.
   *
   * @param ObservableCardReader The reader with which the card communication is carried out.
   * @param detectionMode The card detection mode.
   * @param notificationMode The card notification mode.
   * @since 1.0
   */
  void scheduleCardSelectionScenario(
      ObservableCardReader ObservableCardReader,
      ObservableCardReader.DetectionMode detectionMode,
      ObservableCardReader.NotificationMode notificationMode);

  /**
   * Analyzes the responses received in return of the execution of a card selection scenario and
   * returns the {@link CardSelectionResult}.
   *
   * @param scheduledCardSelectionsResponse The card selection scenario execution response.
   * @return A not null reference.
   * @throws IllegalArgumentException If scheduledCardSelectionsResponse is null.
   * @since 1.0
   */
  CardSelectionResult parseScheduledCardSelectionsResponse(
      ScheduledCardSelectionsResponse scheduledCardSelectionsResponse);
}
