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

import org.calypsonet.terminal.reader.spi.CardReaderObservationExceptionHandlerSpi;
import org.calypsonet.terminal.reader.spi.CardReaderObserverSpi;

/**
 * Card reader able to observe the insertion/removal of cards.
 *
 * @since 1.0.0
 */
public interface ObservableCardReader extends CardReader {

  /**
   * Sets the exception handler.
   *
   * <p>The invocation of this method is <b>mandatory</b> when the reader has to be observed.
   *
   * <p>In case of a fatal error during the observation, the handler will receive a notification.
   *
   * @param exceptionHandler The exception handler implemented by the application.
   * @throws IllegalArgumentException If the provided handler is null.
   * @since 1.0.0
   */
  void setReaderObservationExceptionHandler(
      CardReaderObservationExceptionHandlerSpi exceptionHandler);

  /**
   * Registers a new observer to be notified when a reader event occurs.
   *
   * <p>The provided observer must implement the {@link CardReaderObserverSpi} interface to be able
   * to receive the events produced by this reader (card insertion, removal, etc.)
   *
   * @param observer An observer object implementing the required interface (should be not null).
   * @throws IllegalArgumentException If the provided observer is null.
   * @since 1.0.0
   */
  void addObserver(CardReaderObserverSpi observer);

  /**
   * Unregisters a reader observer.
   *
   * <p>The observer will no longer receive any of the events produced by this reader.
   *
   * @param observer The observer object to be removed (should be not null).
   * @throws IllegalArgumentException If the provided observer is null.
   * @since 1.0.0
   */
  void removeObserver(CardReaderObserverSpi observer);

  /**
   * Unregisters all observers at once.
   *
   * @since 1.0.0
   */
  void clearObservers();

  /**
   * Provides the current number of registered observers.
   *
   * @return An int.
   * @since 1.0.0
   */
  int countObservers();

  /**
   * Starts the card detection. Once activated, the application can be notified of the arrival of a
   * card.
   *
   * <p>The {@link DetectionMode} indicates the action to be followed after processing the card.
   *
   * @param detectionMode The card detection mode.
   * @throws IllegalArgumentException If the provided detection mode is null.
   * @since 1.0.0
   */
  void startCardDetection(DetectionMode detectionMode);

  /**
   * Stops the card detection.
   *
   * @since 1.0.0
   */
  void stopCardDetection();

  /**
   * Notifies the observation process that the processing of the card has been completed in order to
   * ensure that the card monitoring cycle runs properly.
   *
   * <p>This method has no effect if the physical communication channel has already been closed.
   *
   * <p>It is <b>mandatory</b> to invoke this method when the physical communication channel with
   * the card could not be closed properly.<br>
   * The channel closing is nominally managed during the last transmission with the card. However,
   * there are cases where exchanges with the card are interrupted (e.g. by an exception), in which
   * case it is necessary to explicitly close the channel using this method.
   *
   * <p>In practice, it is recommended to invoke this method in all cases (e.g. in a "finally"
   * statement) at the end of a card processing whatever the result.
   *
   * @since 1.0.0
   */
  void finalizeCardProcessing();

  /**
   * Card detection management options to be applied after processing a card.
   *
   * @since 1.0.0
   */
  enum DetectionMode {

    /**
     * Continue waiting for the insertion of a next card.
     *
     * @since 1.0.0
     */
    REPEATING,

    /**
     * Stop and wait for a restart signal.
     *
     * @since 1.0.0
     */
    SINGLESHOT
  }

  /**
   * The options that apply when a card is detected.
   *
   * @since 1.0.0
   */
  enum NotificationMode {

    /**
     * All cards presented to the readers are notified to the observers, regardless of the result of
     * the selection.
     *
     * @since 1.0.0
     */
    ALWAYS,
    /**
     * Only the cards that have been successfully selected will be notified to the observers. The
     * others will be ignored and the application will not be aware of their presence.
     *
     * @since 1.0.0
     */
    MATCHED_ONLY
  }
}
