const router = require("express").Router();

const { google } = require("googleapis");
const { token } = require("morgan");

const GOOGLE_CLIENT_ID =
  "1021661647276-h5rf4p8nr4vs73m8sjvqe2dv7jmru3lr.apps.googleusercontent.com";
const GOOGLE_CLIENT_SECRET = "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";

const REFRESH_TOKEN =
  "1//0gfgSiAIue7w3CgYIARAAGBASNwF-L9IrG0J69ekCFbt52NSY5W5MftuKRxqRr33AAtYFxkeRZGLdS_Xy1JpISYrSbNkIkJFmLhY";
const oauth2Client = new google.auth.OAuth2(
  GOOGLE_CLIENT_ID,
  GOOGLE_CLIENT_SECRET,
  "http://localhost:3000"
);
router.get("/", async (req, res, next) => {
  res.send({ message: "Ok api is working 🚀" });
});

module.exports = router;

router.post("/create-tokens", async (req, res, next) => {
  try {
    const { code } = req.body;
    const { tokens } = await oauth2Client.getToken(code);
    res.send(tokens);
  } catch (error) {
    next(error);
  }
});

router.post("/create-event", async (req, res, next) => {
  try {
    const { summary, description, location, startDateTime, endDateTime } =
      req.body;
    oauth2Client.setCredentials({ refresh_token: REFRESH_TOKEN });
    const calendar = google.calendar("v3");
    const response = await calendar.events.insert({
      auth: oauth2Client,
      calendarId: "primary",

      requestBody: {
        summary: summary,
        description: description,
        location: location,
        colorId: "7",
        start: {
          dateTime: new Date(startDateTime),
          timeZone: "Asia/Kolkata",
        },
        end: {
          dateTime: new Date(endDateTime),
          timeZone: "Asia/Kolkata",
        },
      },
    });
    res.send(response);
  } catch (error) {
    next(error);
  }
});
